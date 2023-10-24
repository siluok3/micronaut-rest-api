package dev.kiri.repository;

import dev.kiri.model.AppUser;
import io.micronaut.data.mongodb.annotation.MongoFindQuery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@MongoRepository
public interface AppUserRepository extends CrudRepository<AppUser, String> {
    @MongoFindQuery("{ name: { $regex: :name, $options: 'i' }}")
    List<AppUser> findByNameLike(String name);
}
