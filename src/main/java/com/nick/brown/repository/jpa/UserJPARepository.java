package com.nick.brown.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nick.brown.entity.User;

public interface UserJPARepository extends PagingAndSortingRepository<User, Long>{

}
