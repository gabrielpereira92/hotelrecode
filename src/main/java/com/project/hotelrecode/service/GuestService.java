package com.project.hotelrecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.repository.GuestRepository;

@Service
public class GuestService {

	private GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}

	public List<Guest> findAllGuest(String name) {
		if (name == null) {
			return guestRepository.findAll();
		} else {
			return guestRepository.findByNameContainingIgnoreCase(name);
		}
	}

	public Guest findGuestById(Long id) {

		return guestRepository.findById(id).orElse(null);

	}

	public Guest saveGuest(Guest guest) {
		guest.setId(null);
		return guestRepository.save(guest);
	}

	public Guest updateGuest(Guest guest) {
		return guestRepository.save(guest);
	}
	
	public void deleteGuestById(Long id) {
		guestRepository.deleteById(id);
	}
	
	public void deleteAllGuest() {
		guestRepository.deleteAll();
	}
	
}
