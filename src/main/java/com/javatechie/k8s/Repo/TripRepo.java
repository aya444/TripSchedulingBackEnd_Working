package com.javatechie.k8s.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.k8s.Model.Trip;

public interface TripRepo extends JpaRepository<Trip, Integer> {

    
}
