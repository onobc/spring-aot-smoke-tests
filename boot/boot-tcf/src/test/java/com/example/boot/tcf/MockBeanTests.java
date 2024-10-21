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

package com.example.boot.tcf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MockBeanTests {

	@MockBean
	private MyComponentImpl myComponentImpl;

	@MockBean
	private MyComponentInterface myComponentInterface;

	@Test
	void shouldMockComponent() {
		Mockito.when(myComponentImpl.value()).thenReturn(2);
		assertThat(myComponentImpl.value()).isEqualTo(2);
	}

	@Test
	void shouldMockInterface() {
		Mockito.when(myComponentInterface.value()).thenReturn(2);
		assertThat(myComponentInterface.value()).isEqualTo(2);
	}

}
