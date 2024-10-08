/*
 * Copyright 2024 the original author or authors.
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
package com.example.data.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;
import org.springframework.aot.smoketest.support.junit.ApplicationTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@ApplicationTest
public class DataWebApplicationAotTests {

	@Test
	void rendersPaged(WebTestClient client) {
		client.get().uri("/paged").exchange().expectBody().jsonPath("page.size").value((size) -> {
			assertThat(size).asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(5);
		}).jsonPath("page.totalPages").value((size) -> {
			assertThat(size).asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(20);
		});
	}

	@Test
	void rendersUnpaged(WebTestClient client) {
		client.get().uri("/unpaged").exchange().expectBody().jsonPath("page.size").value((size) -> {
			assertThat(size).asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(5);
		}).jsonPath("page.totalPages").value((size) -> {
			assertThat(size).asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(1);
		});
	}

}
