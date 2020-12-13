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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	@ApiOperation(value = "Get all accommodation by guest")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(path = "/guest/{guest_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Accommodation>> findAccommodationByGuest(@PathVariable(value = "guest_id") Long id) {
		List<Accommodation> accommodations = accommodationService.findAccommodationByGuest(id);
		return new ResponseEntity<List<Accommodation>>(accommodations, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all accommodation by hotel")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(path = "/hotel/{hotel_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Accommodation>> findAccommodationByHotel(@PathVariable(value = "hotel_id") Long id) {
		List<Accommodation> accommodations = accommodationService.findAccommodationByHotel(id);
		return new ResponseEntity<List<Accommodation>>(accommodations, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Accommodation by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
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

	@ApiOperation(value = "Create accommodation")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request") })
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

	@ApiOperation(value = "Update accommodation")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Accommodation> updateAccommodation(@PathVariable(value = "id") Long id,
			@RequestBody Accommodation accommodation) {
		accommodation.setId(id);
		accommodation = accommodationService.updateAccommodation(accommodation);

		if (accommodation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}

	@ApiOperation(value = "Delete accommodation")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteByIdAccommodation(@PathVariable(value = "id") Long id) {
		accommodationService.deleteAccommodationById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Delete all accommodation")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content") })
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllAccommodation() {
		accommodationService.deleteAllAccommodation();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}