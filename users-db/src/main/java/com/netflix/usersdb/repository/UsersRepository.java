package com.netflix.usersdb.repository;

import com.netflix.usersdb.model.UsersBD;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface  UsersRepository  extends PagingAndSortingRepository<UsersBD, String> {
}
