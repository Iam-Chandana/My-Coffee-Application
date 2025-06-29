/*
 * package com.scratch.coffeeapplication.security;
 * 
 * 
 * 
 * import java.time.Instant; import java.util.stream.Collectors;
 * 
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.oauth2.jwt.JwtClaimsSet; import
 * org.springframework.security.oauth2.jwt.JwtEncoder; import
 * org.springframework.security.oauth2.jwt.JwtEncoderParameters; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * @RestController public class JwtAuthenticationResource {
 * 
 * private JwtEncoder jwtEncodeer;
 * 
 * public JwtAuthenticationResource(JwtEncoder jwtEncodeer) {
 * 
 * this.jwtEncodeer=jwtEncodeer; }
 * 
 * @PostMapping("/authenticate") public JwtResponse authenticate(Authentication
 * authentication) { return new JwtResponse(createToken(authentication)); }
 * 
 * private String createToken(Authentication authentication) {
 * 
 * var claims = JwtClaimsSet.builder() .issuer("self") .issuedAt(Instant.now())
 * .expiresAt(Instant.now().plusSeconds(60*30))
 * .subject(authentication.getName())
 * .claim("scope",createScope(authentication)) .build(); String token
 * =jwtEncodeer.encode(JwtEncoderParameters.from(claims)).getTokenValue();
 * System.out.println("Generated Token: "+token); return
 * jwtEncodeer.encode(JwtEncoderParameters.from(claims)).getTokenValue();
 * 
 * 
 * 
 * JwtEncoderParameters Parameters= JwtEncoderParameters.from(claims); return
 * jwtEncodeer.encode(Parameters).getTokenValue();
 * 
 * 
 * }
 * 
 * private Object createScope(Authentication authentication) { return
 * authentication.getAuthorities().stream() .map(a -> a.getAuthority())
 * .collect(Collectors.joining(" "));
 * 
 * }
 * 
 * } record JwtResponse(String token) {}
 * 
 * 
 */