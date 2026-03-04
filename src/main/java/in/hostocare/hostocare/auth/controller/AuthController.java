package in.hostocare.hostocare.auth.controller;

import in.hostocare.hostocare.auth.dto.LoginRequestDto;
import in.hostocare.hostocare.auth.dto.LoginResponseDto;
import in.hostocare.hostocare.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        LoginResponseDto response = authenticationService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<LoginResponseDto> logout(@Valid @RequestBody LoginRequestDto loginRequest) {
        LoginResponseDto response = authenticationService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
