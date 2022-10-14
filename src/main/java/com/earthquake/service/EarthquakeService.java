package com.earthquake.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.earthquake.model.Earthquake;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class EarthquakeService {


    public List<?> getEarthquakeData(String dt, String searchedCountry) throws JsonProcessingException {

        LocalDate now = LocalDate.now();
        String startDate = now.minusDays(Long.parseLong(dt)).toString();

        ObjectMapper objectMapper = new ObjectMapper();

        String uri = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=" + startDate + "&endtime=" + now;
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(uri, String.class);
        JsonNode jsonNode = objectMapper.readTree(s);

        List<Earthquake> places = new ArrayList<>();
        List<String> empty = new ArrayList<>();

        int i = 0;
        while (jsonNode.get("features").get(i) != null) {

            String dummyCountry = jsonNode.get("features").get(i).get("properties").get("place").asText();
            if (dummyCountry.contains(searchedCountry)) {
                String country = searchedCountry;
                String mag = jsonNode.get("features").get(i).get("properties").get("mag").asText();
                String place = jsonNode.get("features").get(i).get("properties").get("place").asText();
                String dateTime = jsonNode.get("features").get(i).get("properties").get("time").asText();

                long unix_seconds = Long.parseLong(dateTime);
                Date date = new Date(unix_seconds);
                SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateTime = jdf.format(date);

                Earthquake weather = new Earthquake(country, place, mag, dateTime);

                places.add(weather);
            }
            i++;
        }

        if (places.size() == 0) {
            empty.add("No Earthquakes were recorded past " + dt + " days");
            return empty;
        }

        return places;
    }
}

