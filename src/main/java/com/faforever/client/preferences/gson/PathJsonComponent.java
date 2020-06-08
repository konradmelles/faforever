package com.faforever.client.preferences.gson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@JsonComponent
public class PathJsonComponent {

  @SuppressWarnings("unused")
  public static class Serializer extends JsonSerializer<Path> {
    @Override
    public void serialize(Path value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      if (value == null) {
        gen.writeNull();
      } else {
        gen.writeString(value.toAbsolutePath().toString());
      }
    }
  }

  @SuppressWarnings("unused")
  public static class Deserializer extends JsonDeserializer<Path> {

    @Override
    public Path deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      String string = p.getValueAsString();
      if (string == null) {
        return null;
      } else {
        return Paths.get(string);
      }
    }
  }
}
