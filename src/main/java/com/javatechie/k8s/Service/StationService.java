package com.javatechie.k8s.Service;

import com.javatechie.k8s.Model.Station;
import com.javatechie.k8s.Model.Trip;
import com.javatechie.k8s.Repo.StationRepo;
import com.javatechie.k8s.exception.StationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class StationService {
    @Autowired
    private final StationRepo stationRepo; 

    public StationService(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public Station addStation(Station station){
        return stationRepo.save(station);
    }

    public List<Station> findAllStations(){
        return stationRepo.findAll();
    }

    // public Station updateStation(Station station){
    //     return stationRepo.save(station);
    // }

    public void updateStation(Station station,long id){  ////////////////changed her to add id long
        Optional<Station> stationdData = stationRepo.findById(id);
        if (stationdData.isPresent()) {
            Station updatedStation = stationdData.get();
            updatedStation.setName(station.getName());
            updatedStation.setImageUrl(station.getImageUrl());
            stationRepo.save(updatedStation);
        }
    }
    
    public Station findStationById(Long id){
        return stationRepo.findStationById(id).orElseThrow(
                ()-> new StationNotFoundException("Station By id" + id + "was not found")
        );
    }
    public void deleteStation(Long id)
    {
        stationRepo.deleteById(id);
    }

    public Set<Trip> getTripByStationId(Long id){
        Set<Trip> trips= new HashSet<>();
        Station station = findStationById(id);
        trips = station.getTrips();
        return trips;
    }
}
