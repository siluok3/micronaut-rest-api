package dev.kiri.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
@Serdeable.Deserializable
public record Address(String street, String city, int code) {
}
