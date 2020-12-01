package com.project.hotelrecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hotelrecode.model.Accommodation;
import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.model.Hotel;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	
	List<Accommodation> findByGuest(Guest guest);
	
	List<Accommodation> findByHotel(Hotel hotel);

}
