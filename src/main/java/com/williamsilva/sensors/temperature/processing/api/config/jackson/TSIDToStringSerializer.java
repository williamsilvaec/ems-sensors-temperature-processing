package com.williamsilva.sensors.temperature.processing.api.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.hypersistence.tsid.TSID;

import java.io.IOException;

public class TSIDToStringSerializer extends JsonSerializer<TSID> {

    @Override
    public void serialize(TSID tsid, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeString(tsid.toString());
    }
}
