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

import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.service.GuestService;

@RestController
@RequestMapping(path = "/guest", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuestController {

	private GuestService guestService;

	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Guest>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Guest> guests = guestService.findAllGuest(name);
		return new ResponseEntity<List<Guest>>(guests, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Guest> findById(@PathVariable(value = "id") Long id) {
		Guest guest = guestService.findGuestById(id);
		if (guest == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(guest, HttpStatus.OK);

		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
		guest = guestService.saveGuest(guest);

		if (guest == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(guest, HttpStatus.CREATED);
		}
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Guest> updateGuest(@PathVariable(value = "id") Long id, @RequestBody Guest guest) {
		guest.setId(id);
		guest = guestService.updateGuest(guest);

		if (guest == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteByIdGuest(@PathVariable(value = "id") Long id) {
		guestService.deleteGuestById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllGuest(){
		guestService.deleteAllGuest();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
