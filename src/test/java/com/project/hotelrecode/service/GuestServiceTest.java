package com.project.hotelrecode.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.hotelrecode.model.Guest;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class GuestServiceTest {

	@Autowired
	GuestService guestService;

	@Test
	public void initSaveGuestTest() {
		Guest guest = new Guest();

		guest.setName("Américo Pereira");
		guest.setCpf("789.789.356-14");
		guest.setEmail("americo@gmail.com");
		guest.setPassword("euteaaSsmo123");
		guest.setTelephone("(81)994835975");
		guest.setBirthday("31/04/2020");
		guest.setProfile("FIDELITY");

		guestService.saveGuest(guest);
	}

	@Test
	public void initUpdateGuestTest() {
		Guest guest = new Guest();
		guest.setId(8L);
		guest.setName("Sandra Pereira");
		guest.setCpf("789.789.356-14");
		guest.setEmail("americo@gmail.com");
		guest.setPassword("euteaaSsmo123");
		guest.setTelephone("(81)994835975");
		guest.setBirthday("31/04/2020");
		guest.setProfile("FIDELITY");

		guestService.updateGuest(guest);
	}

	@Test
	public void initFindAll() {
		String name = null;

		List<Guest> listGuest = guestService.findAllGuest(name);

		for (Guest guest : listGuest) {
			System.out.println(guest);
		}
	}

	@Test
	public void initFindGuestById() {

		Long id = 8L;

		Guest guest = guestService.findGuestById(id);

		System.out.println(guest);
	}

	@Test
	public void initDeleteById() {

		Long id = 8L;

		guestService.deleteGuestById(id);
	}

	@Test
	public void initDeleteAll() {
		guestService.deleteAllGuest();
	}
}
