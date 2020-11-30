package com.project.hotelrecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hotelrecode.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

	List<Guest> findByNameContainingIgnoreCase(String name);

}
