package com.javatechie.k8s.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.k8s.Model.Station;
import com.javatechie.k8s.Model.Trip;
import com.javatechie.k8s.Repo.StationRepo;
import com.javatechie.k8s.Repo.TripRepo;
import com.javatechie.k8s.exception.StationNotFoundException;

@Service
public class TripService {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private StationRepo stationRepo;

   
    public TripService(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    // public Trip addTrip(Long station_id, Trip trip){
    //     Set<Trip> trips= new HashSet<>();
    //     Station station1 = new Station();

    //     Optional<Station> byId = stationRepo.findById(station_id);
    //     if (!byId.isPresent()) {
    //         throw new StationNotFoundException("Station with id " + station_id + " does not exist");
    //     }
    //     Station station = byId.get();

    //     //tie Author to Book
    //     trip.setStation(station);

    //     Trip trip1 = tripRepo.save(trip);
    //     //tie Book to Author
    //     trips.add(trip1);
    //     station1.setTrips(trips);
    //     return trip1;

    // }

    public Trip addTrip(Trip trip){
        return tripRepo.save(trip);
    }


    public List<Trip> findAllTrips(){
        return tripRepo.findAll();
    }

    public void update(Trip trip, int id){
        Optional<Trip> tripData = tripRepo.findById(id);
        if (tripData.isPresent()) {
            Trip updatedTrip = tripData.get();
            updatedTrip.setArrival_time(trip.getArrival_time());
            updatedTrip.setDeparture_time(trip.getDeparture_time());
            updatedTrip.setFrom_station(trip.getFrom_station());
            updatedTrip.setTo_station(trip.getTo_station());
            tripRepo.save(updatedTrip);
        }
    }

    public String findTripById(int id){
        Trip trip =tripRepo.findById(id).get();
        return trip.toString();
    }

    public void delete(int id){
        Trip deletedTrip =tripRepo.findById(id).get();
        tripRepo.delete(deletedTrip);
    }

    public void deleteAllTrips(){
        tripRepo.deleteAll();
    }

}
