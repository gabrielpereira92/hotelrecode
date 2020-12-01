package com.project.hotelrecode.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.hotelrecode.model.Accommodation;
import com.project.hotelrecode.model.Guest;
import com.project.hotelrecode.model.Hotel;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AccommodationRepositoryTest {

	@Autowired
	private AccommodationRepository accommodationRepository;

	@Test
	public void saveAccommodation() {
		Guest guest = new Guest();
		guest.setId(1L);

		Hotel hotel = new Hotel();
		hotel.setId(1L);

		Accommodation accommodation = new Accommodation();
		accommodation.setId(null);
		accommodation.setStartDay("01/12/2020");
		accommodation.setEndDay("05/12/2020");
		accommodation.setValueReservation(550.50);
		accommodation.setGuest(guest);
		accommodation.setHotel(hotel);
		accommodationRepository.save(accommodation);

	}

	@Test
	public void updateAccommodation() {
		Accommodation accommodation = new Accommodation();
		accommodation.setId(1L);

		Guest guest = new Guest();
		guest.setId(1L);

		Hotel hotel = new Hotel();
		hotel.setId(1L);

		accommodation.setStartDay("01/12/2020");
		accommodation.setEndDay("05/12/2020");
		accommodation.setValueReservation(550.50);
		accommodation.setGuest(guest);
		accommodation.setHotel(hotel);
		accommodationRepository.save(accommodation);

	}

	@Test
	public void findAllAccommodation() {
		List<Accommodation> list = accommodationRepository.findAll();

		for (Accommodation accommodation : list) {
			System.out.println(accommodation);

		}
	}

	@Test
	public void findAccommodationById() {
		Long id = 1L;
		Optional<Accommodation> optional = accommodationRepository.findById(id);

		Accommodation accommodation = optional.orElse(null);

		System.out.println(accommodation);

	}

	public void findByHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(1L);

		List<Accommodation> accommodations = accommodationRepository.findByHotel(hotel);

		for (Accommodation accommodation : accommodations) {

			System.out.println(accommodation);
		}
	}

	public void findByGuest() {
		Guest guest = new Guest();
		guest.setId(1L);

		List<Accommodation> accommodations = accommodationRepository.findByGuest(guest);

		for (Accommodation accommodation : accommodations) {

			System.out.println(accommodation);
		}

	}

	@Test
	public void deleteAccommodationById() {
		Long id = 1L;
		accommodationRepository.deleteById(id);
	}

	@Test
	public void deleteAllAccommodation() {
		accommodationRepository.deleteAll();
	}
}
