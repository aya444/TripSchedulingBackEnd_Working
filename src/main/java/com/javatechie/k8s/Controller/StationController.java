package com.javatechie.k8s.Controller;

import com.javatechie.k8s.Model.Station;
import com.javatechie.k8s.Model.Trip;
import com.javatechie.k8s.Service.StationService;
import com.javatechie.k8s.exception.StationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/station")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Station>> getAllStations(){
        List<Station> Stations = stationService.findAllStations();
        return new ResponseEntity<>(Stations , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<? extends Serializable> getStationById(@PathVariable("id") Long id){
        try{
            Station Station = stationService.findStationById(id);
            return new ResponseEntity<Station>(Station,HttpStatus.OK);
        }
        catch (StationNotFoundException stationNotFoundException){
            return new ResponseEntity<String>("Station of Id " + id + " wasn't not aleardy exist",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTrips/{id}")
    public ResponseEntity<Set<Trip>> getAllTrips(@PathVariable("id") Long id){
        Set<Trip> trips = stationService.getTripByStationId(id);
        return new ResponseEntity<>(trips , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Station> addStation(@RequestBody Station station){
        Station newStation = stationService.addStation(station);
        return new ResponseEntity<>(newStation,HttpStatus.CREATED);
    }

    // @PutMapping("/update")
    // public ResponseEntity<Station> updateStation(@RequestBody Station station){
    //     Station updateStation = stationService.updateStation(station);
    //     return new ResponseEntity<>(updateStation,HttpStatus.OK);
    // }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStation(@PathVariable long id, @RequestBody Station station){
        try {
            stationService.updateStation(station,id);
            return new ResponseEntity<String>("Updated Station with id: "+ id, HttpStatus.OK);
        } 
        catch(Exception e) {
            return new ResponseEntity<String>("Station with id: "+ id+" does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStation(@PathVariable("id") Long id) {
        stationService.deleteStation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
