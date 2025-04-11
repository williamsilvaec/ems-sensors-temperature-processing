package com.williamsilva.sensors.temperature.processing.api.controller;

import com.williamsilva.sensors.temperature.processing.api.model.TemperatureLogOutput;
import io.hypersistence.tsid.TSID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
public class TemperatureProcessingController {

    private static final Logger log = LoggerFactory.getLogger(TemperatureProcessingController.class);

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void data(@PathVariable TSID sensorId, @RequestBody String input) {
        if (!StringUtils.hasText(input)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        double temperature;

        try {
            temperature = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid temperature value", e);
        }

        TemperatureLogOutput logOutput = TemperatureLogOutput
                .create(sensorId, temperature);

        log.info(logOutput.toString());
    }

}
