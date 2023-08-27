package com.mka.users.service.UserService.payload;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", success=" + success + ", status=" + status + "]";
	}
	public void setApiResponce(String message, boolean success, HttpStatus status) {
		
		this.message = message;
		this.success = success;
		this.status = status;
	}
}
