package com.project.hotelrecode.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.hotelrecode.model.Accommodation;
import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.model.Hotel;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AccommodationServiceTest {

	@Autowired
	AccommodationService accommodationService;

	@Test
	public void initSaveAccommodationTest() {
		Hotel hotel = new Hotel();
		hotel.setId(2L);

		Guest guest = new Guest();
		guest.setId(1L);

		Accommodation accommodation = new Accommodation();
		accommodation.setValueReservation(355);
		accommodation.setEndDay("15/05/2020");
		accommodation.setStartDay("10/05/2020");
		accommodation.setHotel(hotel);
		accommodation.setGuest(guest);

		accommodationService.saveAccommodation(accommodation);
	}

	@Test
	public void initUpdateAccommodationTest() {
		Hotel hotel = new Hotel();
		hotel.setId(2L);

		Guest guest = new Guest();
		guest.setId(1L);

		Accommodation accommodation = new Accommodation();
		accommodation.setId(3L);
		accommodation.setValueReservation(310);
		accommodation.setEndDay("12/05/2020");
		accommodation.setStartDay("05/05/2020");
		accommodation.setHotel(hotel);
		accommodation.setGuest(guest);

		accommodationService.updateAccommodation(accommodation);
	}

	@Test
	public void initFindAll() {
		List<Accommodation> listAccommodation = accommodationService.findAllAccommodation();

		for (Accommodation accommodation : listAccommodation) {
			System.out.println(accommodation);
		}
	}

	@Test
	public void initFindAccommodationById() {

		Long id = 4L;

		Accommodation accommodation = accommodationService.findAccommodationById(id);

		System.out.println(accommodation);
	}

	@Test
	public void initFindAccommodationByGuest() {

		Long id = 1L;

		List<Accommodation> list = accommodationService.findAccommodationByGuest(id);

		for (Accommodation accommodation : list) {
			System.out.println(accommodation);

		}
	}

	@Test
	public void initFindAccommodationByHotel() {

		Long id = 2L;

		List<Accommodation> list = accommodationService.findAccommodationByHotel(id);

		for (Accommodation accommodation : list) {
			System.out.println(accommodation);

		}
	}
	
	@Test
	public void initDeleteById() {
		Long id = 8L;
		accommodationService.deleteAccommodationById(id);
	}

	@Test
	public void initDeleteAll() {
		accommodationService.deleteAllAccommodation();
	}

}
