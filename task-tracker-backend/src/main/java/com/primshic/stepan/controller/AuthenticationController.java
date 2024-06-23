package com.primshic.stepan.controller;

import com.primshic.stepan.dto.AuthenticationRequest;
import com.primshic.stepan.dto.AuthenticationResponse;
import com.primshic.stepan.service.AuthenticationService;
import com.primshic.stepan.dto.RegisterRequest;
import com.primshic.stepan.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

}
