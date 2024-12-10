package com.ramon.PicPayBackendChallenge.repository;

import com.ramon.PicPayBackendChallenge.model.Picpayuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Picpayuser, Integer> { }