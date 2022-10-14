package com.earthquake.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.earthquake.service.EarthquakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EarthquakeController {

    EarthquakeService earthquakeService = new EarthquakeService();

    // Example request localhost:8080/earthquake?days=30&country=Turkey
    @RequestMapping(value = "/earthquake", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<?> getEarthquakes(@RequestParam(name = "days") String dt, @RequestParam(name = "country") String ct) throws JsonProcessingException {
        return earthquakeService.getEarthquakeData(dt, ct);
    }

}
