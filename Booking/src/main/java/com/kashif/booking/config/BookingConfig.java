package com.kashif.booking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

