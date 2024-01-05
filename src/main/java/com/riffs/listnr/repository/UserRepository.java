package com.riffs.listnr.repository;

import org.springframework.data.repository.CrudRepository;

import com.riffs.listnr.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
