package com.javatechie.k8s.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trip {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
	private String from_station;
    @Column
	private String to_station;
    @Column
	private String departure_time;
    @Column
	private String arrival_time;

	@ManyToOne
    @JoinColumn(name = "station_id")
	public Station station;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   

	public String getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}  

	public String getTo_station() {
		return this.to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}   

	public String getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}   

	public String getArrival_time() {
		return this.arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	@JsonIgnore
	public void setStation(Station station) {
		this.station = station;
	} 
    
	@JsonIgnore
    public void setTripCode(String string) {
    }

	public String toString(){
		return "The Trip info of id: " + this.id 
		+ "\nfrom station: " + this.from_station
		+ "\nto station: "+ this.to_station
		+ "\ndeparture time: "+ this.departure_time
		+ "\narrival time: "+ this.arrival_time;
	  }
}

