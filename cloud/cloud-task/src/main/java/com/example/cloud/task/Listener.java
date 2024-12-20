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

package com.example.cloud.task;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@BeforeTask
	public void beforeTask(TaskExecution taskExecution) {
		System.out.printf("Before task: %s%n", taskExecution.getTaskName());
	}

	@AfterTask
	public void afterTask(TaskExecution taskExecution) {
		System.out.printf("After task: %s%n", taskExecution.getTaskName());
	}

	@FailedTask
	public void failedTask(TaskExecution taskExecution, Throwable throwable) {
		System.out.printf("Failed task: %s: %s%n", taskExecution.getTaskName(), throwable);
	}

}
