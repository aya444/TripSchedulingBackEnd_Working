package com.javatechie.k8s.Repo;

import com.javatechie.k8s.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepo extends JpaRepository<Station,Long> {

    Optional<Station> findStationById(Long id);
}
