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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotelrecode.model.Accommodation;
import com.project.hotelrecode.service.AccommodationService;

@RestController
@RequestMapping(path = "/accommodation", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccommodationController {
	
	private AccommodationService accommodationService;

	public AccommodationController(AccommodationService accommodationService) {
		super();
		this.accommodationService = accommodationService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Accommodation>> findAll() {
		List<Accommodation> accommodations = accommodationService.findAllAccommodation();
		return new ResponseEntity<List<Accommodation>>(accommodations, HttpStatus.OK);
	}
	
	@GetMapping(path = "/guest/{guest_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Accommodation>> findAccommodationByGuest(@PathVariable(value = "guest_id")Long id) {
		List<Accommodation> accommodations = accommodationService.findAccommodationByGuest(id);
		return new ResponseEntity<List<Accommodation>>(accommodations, HttpStatus.OK);
	}
	
	@GetMapping(path = "/hotel/{hotel_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Accommodation>> findAccommodationByHotel(@PathVariable(value = "hotel_id")Long id) {
		List<Accommodation> accommodations = accommodationService.findAccommodationByHotel(id);
		return new ResponseEntity<List<Accommodation>>(accommodations, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Accommodation> findById(@PathVariable(value = "id") Long id) {
		Accommodation accommodation = accommodationService.findAccommodationById(id);
		if (accommodation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(accommodation, HttpStatus.OK);

		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
		accommodation = accommodationService.saveAccommodation(accommodation);

		if (accommodation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(accommodation, HttpStatus.CREATED);
		}
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Accommodation> updateAccommodation(@PathVariable(value = "id") Long id, @RequestBody Accommodation accommodation) {
		accommodation.setId(id);
		accommodation = accommodationService.updateAccommodation(accommodation);

		if (accommodation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteByIdAccommodation(@PathVariable(value = "id") Long id) {
		accommodationService.deleteAccommodationById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllAccommodation(){
		accommodationService.deleteAllAccommodation();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}