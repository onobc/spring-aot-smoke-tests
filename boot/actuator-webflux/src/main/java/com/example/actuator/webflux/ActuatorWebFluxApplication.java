/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.actuator.webflux;

import java.util.Map;

import com.example.actuator.webflux.health.AnotherCustomHealthIndicator;
import com.example.actuator.webflux.health.CustomHealthIndicator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.CompositeReactiveHealthContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorWebFluxApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ActuatorWebFluxApplication.class, args);
		Thread.currentThread().join(); // To be able to measure memory consumption
	}

	@Bean("composite")
	CompositeReactiveHealthContributor compositeReactiveHealthContributor(CustomHealthIndicator customHealthIndicator,
			AnotherCustomHealthIndicator anotherCustomHealthIndicator) {
		return CompositeReactiveHealthContributor
			.fromMap(Map.of("custom", customHealthIndicator, "another-custom", anotherCustomHealthIndicator));
	}

}
