package com.ramon.PicPayBackendChallenge.repository;

import com.ramon.PicPayBackendChallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }