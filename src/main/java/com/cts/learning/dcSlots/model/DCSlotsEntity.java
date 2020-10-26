package com.cts.learning.dcSlots.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity(name="dc_slots")
public class DCSlotsEntity {
	
	@Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dc_id")
    private DCEntity dc;
	
    @NotNull
    @Column(name = "time_slots")
    private String timeSlots;
    
    @Column(name = "max_trucks")
    private Integer maxTrucks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DCEntity getDc() {
		return dc;
	}

	public void setDc(DCEntity dc) {
		this.dc = dc;
	}

	public String getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(String timeSlots) {
		this.timeSlots = timeSlots;
	}

	public Integer getMaxTrucks() {
		return maxTrucks;
	}

	public void setMaxTrucks(Integer maxTrucks) {
		this.maxTrucks = maxTrucks;
	}

}
