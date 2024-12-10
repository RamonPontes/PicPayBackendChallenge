package com.ramon.PicPayBackendChallenge.repository;

import com.ramon.PicPayBackendChallenge.model.PicPayUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PicPayUser, Integer> { }