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

import com.project.hotelrecode.model.Hotel;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class HotelRepositoryTest {
	
	@Autowired
	private HotelRepository hotelRepository;


	@Test
	public void saveHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(null);
		hotel.setName("Hotel Parque da Costeira");
		hotel.setEmail("adm@parquedacosteira.com.br");
		hotel.setTelephone("(81)34355678");
		hotel.setClassification(3);
		hotel.setPriceWeekendRegular(55.0);
		hotel.setPriceWeekendFidelity(45.9);
		hotel.setPriceWeekRegular(40.5);
		hotel.setPriceWeekFidelity(30.5);
		
		hotelRepository.save(hotel);

	}

	@Test
	public void updateHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(1L);
	
		hotelRepository.save(hotel);

	}

	@Test
	public void findAllHotel() {
		List<Hotel> list = hotelRepository.findAll();

		for (Hotel hotel : list) {
			System.out.println(hotel);

		}
	}

	@Test
	public void findHotelById() {
		Long id = 1L;
		Optional<Hotel> optional = hotelRepository.findById(id);

		Hotel hotel = optional.orElse(null);

		System.out.println(hotel);

	}
	@Test
	public void deleteHotelById() {
		Long id = 1L;
		hotelRepository.deleteById(id);
	}
	
	@Test
	public void deleteAllHotel() {
		hotelRepository.deleteAll();
	}
}
	

