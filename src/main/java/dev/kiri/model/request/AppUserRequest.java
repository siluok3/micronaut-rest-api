package dev.kiri.model.request;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
@Serdeable.Deserializable
public record AppUserRequest(String name, String email, String street, String city, int code) {
}
