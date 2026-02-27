package dev.archety.introduzione.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@Value("${app.name:DemoApplicazione}")
	private String appName;
	
	@GetMapping("/hello")
	private String hello() {
		return "Ciao, io sono: " + this.appName;
	}
	
}
