package com.williamsilva.sensors.temperature.processing.api.model;

import com.williamsilva.sensors.temperature.processing.common.IdGenerator;
import io.hypersistence.tsid.TSID;

import java.time.OffsetDateTime;
import java.util.UUID;

public record TemperatureLogOutput(
        UUID id,
        TSID sensorId,
        OffsetDateTime registeredAt,
        Double value
) {

    public static TemperatureLogOutput create(TSID sensorId, Double value) {
        return new TemperatureLogOutput(
                IdGenerator.generateTimeBasedUUID(),
                sensorId,
                OffsetDateTime.now(),
                value
        );
    }
}
