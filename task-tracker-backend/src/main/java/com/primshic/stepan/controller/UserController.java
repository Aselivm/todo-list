package com.primshic.stepan.controller;

import com.primshic.stepan.dto.AuthenticationResponse;
import com.primshic.stepan.dto.UserResponse;
import com.primshic.stepan.exception.ErrorResponse;
import com.primshic.stepan.dto.RegisterRequest;
import com.primshic.stepan.model.User;
import com.primshic.stepan.service.AuthenticationService;
import com.primshic.stepan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AuthenticationService service;

    private final UserService userService;
    @PostMapping
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body(new ErrorResponse("Unauthorized"));
        }
        UserResponse userResponse = userService.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(userResponse);
    }

}
