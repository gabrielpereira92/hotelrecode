package com.project.hotelrecode.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelrecode.model.Hotel;
import com.project.hotelrecode.service.HotelService;

@RestController
@RequestMapping(path = "/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {
	
	private HotelService hotelService;

	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Hotel>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Hotel> hotels = hotelService.findAllHotel(name);
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Hotel> findById(@PathVariable(value = "id") Long id) {
		Hotel hotel = hotelService.findHotelById(id);
		if (hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(hotel, HttpStatus.OK);

		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		hotel = hotelService.saveHotel(hotel);

		if (hotel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(hotel, HttpStatus.CREATED);
		}
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") Long id, @RequestBody Hotel hotel) {
		hotel.setId(id);
		hotel = hotelService.updateHotel(hotel);

		if (hotel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteByIdHotel(@PathVariable(value = "id") Long id) {
		hotelService.deleteHotelById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllHotel(){
		hotelService.deleteAllHotel();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
