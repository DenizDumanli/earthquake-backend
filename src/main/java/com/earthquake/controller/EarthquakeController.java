package com.earthquake.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.earthquake.service.EarthquakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EarthquakeController {

    EarthquakeService earthquakeService = new EarthquakeService();

    @RequestMapping(value = "/earthquake&days={dt}&country={ct}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<?> getEarthquakes(@PathVariable String dt, @PathVariable String ct) throws JsonProcessingException {
        return earthquakeService.getEarthquakeData(dt, ct);
    }

}
