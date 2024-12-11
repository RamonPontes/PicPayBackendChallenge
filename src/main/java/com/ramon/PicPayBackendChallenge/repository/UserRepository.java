package com.ramon.PicPayBackendChallenge.repository;

import com.ramon.PicPayBackendChallenge.model.Picpayuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Picpayuser, Integer> {
    Optional<Picpayuser> findByEmail(String email);
    Optional<Picpayuser> findByDocument(String document);
}