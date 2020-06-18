package com.spring.boot.rocks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.rocks.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	List<AppUser> findByUserenabledTrue();

	List<AppUser> findByUserenabledFalse();

}
