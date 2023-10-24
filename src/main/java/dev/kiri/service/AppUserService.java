package dev.kiri.service;

import dev.kiri.model.Address;
import dev.kiri.model.AppUser;
import dev.kiri.model.request.SearchRequest;
import dev.kiri.repository.AppUserRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public @NonNull AppUser create(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    public AppUser getUser(String userId) {
        return appUserRepository
                .findById(userId)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, "User was not found"));
    }

    public AppUser updateUser(String userId, AppUser appUser) {
        AppUser existingUser = getUser(userId);

        existingUser.setName(appUser.getName());
        existingUser.setEmail(appUser.getEmail());
        existingUser.setAddress(appUser.getAddress());

        return appUserRepository.update(existingUser);
    }

    public void delete(String userId) {
        AppUser existingUser = getUser(userId);

        appUserRepository.delete(existingUser);
    }

    public List<AppUser> search(SearchRequest searchRequest) {
        return appUserRepository.findByNameLike(searchRequest.name());
    }
}
