package com.project.hotelrecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hotelrecode.model.Accommodation;
import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.model.Hotel;
import com.project.hotelrecode.repository.AccommodationRepository;

@Service
public class AccommodationService {

	private AccommodationRepository accommodationRepository;

	public AccommodationService(AccommodationRepository accommodationRepository) {
		super();
		this.accommodationRepository = accommodationRepository;
	}

	public List<Accommodation> findAllAccommodation() {
		return accommodationRepository.findAll();

	}

	public Accommodation findAccommodationById(Long id) {
		return accommodationRepository.findById(id).orElse(null);
	}

	public List<Accommodation> findAccommodationByGuest(Long id) {
		Guest guest = new Guest();
		guest.setId(id);
		return accommodationRepository.findByGuest(guest);
	}

	public List<Accommodation> findAccommodationByHotel(Long id) {
		Hotel hotel = new Hotel();
		hotel.setId(id);
		return accommodationRepository.findByHotel(hotel);
	}

	public Accommodation saveAccommodation(Accommodation accommodation) {
		accommodation.setId(null);
		return accommodationRepository.save(accommodation);
	}

	public Accommodation updateAccommodation(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}

	public void deleteAccommodationById(Long id) {
		accommodationRepository.deleteById(id);
	}

	public void deleteAllAccommodation() {
		accommodationRepository.deleteAll();
	}

}
