package com.Ycoy.UserAuth;

import com.Ycoy.UserAuth.dto.LoginRequest;
import com.Ycoy.UserAuth.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

// Added these imports for the JSON response map
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 1. ADDED THIS: Inject the JwtUtil
    @Autowired
    private JwtUtil jwtUtil; 

    // FR 1.1: Registration
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // FR 1.2: Hashing

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    // FR 1.3: Login (2. UPDATED THIS METHOD)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            
            // Generate the JWT Token using the new util class
            String token = jwtUtil.generateToken(user.get().getEmail());
            
            // Create a JSON response containing the token and user info
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login Successful!");
            response.put("token", token);
            response.put("email", user.get().getEmail());
            response.put("username", user.get().getUsername());
            
            return ResponseEntity.ok(response);
            
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    // FR 1.4: Logout
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        // Note: For JWT, the primary logout mechanism is the frontend deleting the token.
        // This endpoint serves as a successful acknowledgment for the API call.
        // You can add token blacklisting logic here in the future if required.
        return ResponseEntity.ok("Logout Successful!");
    }
}