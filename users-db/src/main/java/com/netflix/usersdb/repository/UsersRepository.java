package com.netflix.usersdb.repository;

import com.netflix.usersdb.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface  UsersRepository  extends PagingAndSortingRepository<Users, String> {
}
