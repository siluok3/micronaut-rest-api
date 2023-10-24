package dev.kiri.model.mapper;

import dev.kiri.model.Address;
import dev.kiri.model.AppUser;
import dev.kiri.model.request.AppUserRequest;

public class AppUserMapper {
    public static AppUser mapToAppUser(AppUserRequest appUserRequest) {
        Address address = new Address(appUserRequest.street(), appUserRequest.city(), appUserRequest.code());

        return new AppUser(appUserRequest.name(), appUserRequest.email(), address);
    }
}
