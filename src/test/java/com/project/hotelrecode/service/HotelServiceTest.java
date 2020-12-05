package com.project.hotelrecode.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.hotelrecode.model.Hotel;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class HotelServiceTest {
	
	@Autowired
	HotelService hotelService;
	
	@Test
	public void initSaveHotelTest() {
		Hotel hotel = new Hotel();
		hotel.setId(null);
		hotel.setName("Hotel Parque da Colina");
		hotel.setEmail("adm@parquedacolina.com.br");
		hotel.setTelephone("(81)34455678");
		hotel.setClassification(4);
		hotel.setPriceWeekendRegular(57.0);
		hotel.setPriceWeekendFidelity(49.9);
		hotel.setPriceWeekRegular(42.5);
		hotel.setPriceWeekFidelity(34.5);
		
		hotelService.saveHotel(hotel);
	}

	@Test
	public void initUpdateHotelTest() {
		Hotel hotel = new Hotel();
		hotel.setId(1L);
		hotel.setName("Hotel água amarela");
		hotel.setEmail("adm@hotelaguaamarela.com.br");
		hotel.setTelephone("(81)34455678");
		hotel.setClassification(2);
		hotel.setPriceWeekendRegular(20.0);
		hotel.setPriceWeekendFidelity(19.9);
		hotel.setPriceWeekRegular(32.5);
		hotel.setPriceWeekFidelity(44.5);
	

		hotelService.updateHotel(hotel);
	}

	@Test
	public void initFindAll() {
		String name = "parque";

		List<Hotel> listHotel = hotelService.findAllHotel(name);

		for (Hotel hotel : listHotel) {
			System.out.println(hotel);
		}
	}

	@Test
	public void initFindHotelById() {

		Long id = 1L;

		Hotel hotel = hotelService.findHotelById(id);

		System.out.println(hotel);
	}

	@Test
	public void initDeleteById() {

		Long id = 1L;

		hotelService.deleteHotelById(id);
	}

	@Test
	public void initDeleteAll() {
		hotelService.deleteAllHotel();
	}

}
