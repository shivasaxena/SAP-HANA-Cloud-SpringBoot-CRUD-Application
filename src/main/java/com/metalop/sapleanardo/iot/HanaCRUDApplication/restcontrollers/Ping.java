package com.metalop.sapleanardo.iot.HanaCRUDApplication.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

	@GetMapping("/ping")
	public String pingController() {
		return "Hello World";
	}
}
