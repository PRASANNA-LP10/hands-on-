    package com.cognizant.spring_learn.controller;

    import com.cognizant.spring_learn.util.JwtUtil;
    import org.springframework.security.core.Authentication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    import com.cognizant.spring_learn.model.AuthenticationResponse;


        @RestController
        public class AuthenticationController {

            private final JwtUtil jwtUtil;

            public AuthenticationController(JwtUtil jwtUtil) {
                this.jwtUtil = jwtUtil;
            }

            @GetMapping("/authenticate")
            public AuthenticationResponse authenticate(Authentication authentication) {

                String token = jwtUtil.generateToken(authentication.getName());

                return new AuthenticationResponse(token);
            }
        }

