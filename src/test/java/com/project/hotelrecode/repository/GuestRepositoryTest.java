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

import com.project.hotelrecode.model.Guest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class GuestRepositoryTest {

	@Autowired
	private GuestRepository guestRepository;

	@Test
	public void saveGuest() {
		Guest guest = new Guest();
		guest.setId(null);
		guest.setName("Julianny Pereira");
		guest.setCpf("789.789.456-25");
		guest.setEmail("julianny@gmail.com");
		guest.setPassword("euteamo123");
		guest.setTelephone("(81)984835973");
		guest.setBirthday("15/05/1993");
		guest.setProfile("Fidelity");

		guestRepository.save(guest);

	}

	@Test
	public void updateGuest() {
		Guest guest = new Guest();
		guest.setId(1L);
		guest.setName("Adam Pereira");
		guest.setCpf("789.789.456-15");
		guest.setEmail("Adam@gmail.com");
		guest.setPassword("euteamo123");
		guest.setTelephone("(81)984835972");
		guest.setBirthday("31/05/2018");
		guest.setProfile("Fidelity");

		guestRepository.save(guest);

	}

	@Test
	public void findAllGuest() {
		List<Guest> list = guestRepository.findAll();

		for (Guest guest : list) {
			System.out.println(guest);

		}
	}

	@Test
	public void findGuestById() {
		Long id = 1L;
		Optional<Guest> optional = guestRepository.findById(id);

		Guest guest = optional.orElse(null);

		System.out.println(guest);

	}
	@Test
	public void deleteGuestById() {
		Long id = 1L;
		guestRepository.deleteById(id);
	}
	
	@Test
	public void deleteAllGuest() {
		guestRepository.deleteAll();
	}
}
