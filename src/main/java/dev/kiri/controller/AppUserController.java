package dev.kiri.controller;

import dev.kiri.model.AppUser;
import dev.kiri.model.mapper.AppUserMapper;
import dev.kiri.model.request.AppUserRequest;
import dev.kiri.model.request.SearchRequest;
import dev.kiri.service.AppUserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/user")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Get
    public List<AppUser> getAll() {
        return appUserService.getAll();
    }

    @Get("/{userId}")
    public AppUser getUser(@PathVariable String userId) {
        return appUserService.getUser(userId);
    }

    @Post
    @Status(HttpStatus.CREATED)
    public AppUser create(@Body AppUserRequest appUserRequest) {
        return appUserService.create(AppUserMapper.mapToAppUser(appUserRequest));
    }

    @Post("/search")
    public List<AppUser> search(@Body SearchRequest searchRequest) {
        return appUserService.search(searchRequest);
    }

    @Put("/{userId}")
    public AppUser update(@PathVariable String userId, @Body AppUserRequest appUserRequest, @Header("X-Foo") String header)  {
        System.out.println("Header: "+header);

        return appUserService.updateUser(userId, AppUserMapper.mapToAppUser(appUserRequest));
    }

    @Delete("/{userId}")
    @Status(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String userId) {
        appUserService.delete(userId);
    }
}
