package com.example.cloud.discovery.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConsulDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulDiscoveryClientApplication.class, args);
	}

	@RestController
	static class TestController {

		@GetMapping("/")
		public String test() {
			return "test";
		}

	}

}
