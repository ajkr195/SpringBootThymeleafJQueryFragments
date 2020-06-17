package com.spring.boot.rocks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	List<AppUser> findByUserenabledTrue();

	List<AppUser> findByUserenabledFalse();

}
