package com.project.hotelrecode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hotelrecode.model.Hotel;
import com.project.hotelrecode.repository.HotelRepository;

@Service
public class HotelService {
	
	private HotelRepository hotelRepository;

	public HotelService(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	public List<Hotel> findAllHotel(String name) {
		if (name == null) {
			return hotelRepository.findAll();
		} else {
			return hotelRepository.findByNameContainingIgnoreCase(name);
		}
	}

	public Hotel findHotelById(Long id) {

		return hotelRepository.findById(id).orElse(null);

	}

	public Hotel saveHotel(Hotel hotel) {
		hotel.setId(null);
		return hotelRepository.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public void deleteHotelById(Long id) {
		hotelRepository.deleteById(id);
	}
	
	public void deleteAllHotel() {
		hotelRepository.deleteAll();
	}

}
