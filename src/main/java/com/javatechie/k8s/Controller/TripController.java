package com.javatechie.k8s.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.k8s.Model.Trip;
import com.javatechie.k8s.Service.TripService;

@RestController
@RequestMapping("/api")
public class TripController {

    private TripService tripService;
    
    public TripController(TripService tripService){
        this.tripService=tripService;
    }

    @GetMapping(value = "/trips")
    public List<Trip> getAllTrips(){
        return tripService.findAllTrips();
    }

    @GetMapping(value = "/trips/{id}")
    public ResponseEntity<String> getTripById(@PathVariable int id){
        try {
            return new ResponseEntity<String>(tripService.findTripById(id), HttpStatus.OK);
        } 
        catch(Exception e) {
            return new ResponseEntity<String>("Trip with id: "+ id+" does not exist", HttpStatus.NOT_FOUND);
        }
    }

    // @PostMapping(value = "/{station_id}/trips")
    // public String createTrip(@PathVariable(value = "station_id") Long station_id, @RequestBody Trip trip){
    //     tripService.addTrip(station_id,trip);
    //     return "Saved Trip";
    // }
    
    @PostMapping(value = "/trips")
    public String createTrip(@RequestBody Trip trip){
        tripService.addTrip(trip);
        return "Saved Trip";
    }
    
    @PutMapping(value = "/trips/{id}")
    public ResponseEntity<String> updateTrip(@PathVariable int id,@RequestBody Trip trip){

        try {
            tripService.update(trip, id);
            return new ResponseEntity<String>("Updated Trip with id: "+ id, HttpStatus.OK);
        } 
        catch(Exception e) {
            return new ResponseEntity<String>("Trip with id: "+ id+" does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/trips/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable int id){

        try {
            tripService.delete(id);
            return new ResponseEntity<String>("Trip with id: "+ id + " has been deleted", HttpStatus.OK);
        } 
        catch(Exception e) {
            return new ResponseEntity<String>("Trip with id: "+ id+" does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/trips")
    public ResponseEntity<String> deleteAllTrips() {
        try {
            tripService.deleteAllTrips();
            return new ResponseEntity<String>("All Trips have been deleted.", HttpStatus.OK);
        } 
        catch(Exception e) {
            return new ResponseEntity<String>("No trips existed to be deleted.", HttpStatus.OK);
        }
    }
    
}
