package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}