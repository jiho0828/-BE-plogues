package com.iso.plogues.auth.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iso.plogues.api.model.vo.ApiResponse;
import com.iso.plogues.auth.model.dto.LoginRequestDto;
import com.iso.plogues.auth.model.dto.LoginResponse;
import com.iso.plogues.auth.model.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequestDto lrd){
		LoginResponse res = authService.login(lrd);
		return ResponseEntity.ok().body(ApiResponse.success("로그인 성공", res));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<ApiResponse<Map<String, String>>> refresh(@RequestBody Map<String, String> token) {
		Map<String, String> tokens = authService.refresh(token.get("refreshToken"));
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(tokens));
	}

}
