package dev.kiri.model.request;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
@Serdeable.Deserializable
public record SearchRequest(String name) {
}
