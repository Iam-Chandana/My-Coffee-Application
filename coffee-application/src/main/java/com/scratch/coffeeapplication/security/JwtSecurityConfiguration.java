/*
 * package com.scratch.coffeeapplication.security;
 * 
 * import static org.springframework.security.config.Customizer.withDefaults;
 * 
 * import java.security.KeyPair; import java.security.KeyPairGenerator; import
 * java.security.interfaces.RSAPublicKey; import java.util.UUID;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.oauth2.jwt.JwtDecoder; import
 * org.springframework.security.oauth2.jwt.JwtEncoder; import
 * org.springframework.security.oauth2.jwt.NimbusJwtDecoder; import
 * org.springframework.security.oauth2.jwt.NimbusJwtEncoder; import
 * org.springframework.security.provisioning.JdbcUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain; import
 * com.nimbusds.jose.JOSEException; import com.nimbusds.jose.jwk.JWKSet; import
 * com.nimbusds.jose.jwk.RSAKey; import com.nimbusds.jose.jwk.source.JWKSource;
 * import com.nimbusds.jose.proc.SecurityContext;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class JwtSecurityConfiguration {
 * 
 * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)throws
 * Exception { http.authorizeHttpRequests((requests)
 * ->requests.anyRequest().authenticated());
 * 
 * //http.formLogin(withDefaults()); http.sessionManagement(session ->
 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
 * http.httpBasic(withDefaults()); http.csrf(csrf -> csrf.disable());
 * http.headers(header -> header.frameOptions(frameOptions
 * ->frameOptions.disable()));
 * 
 * http.oauth2ResourceServer(oauth2->oauth2.jwt(withDefaults())); return
 * http.build(); }
 * 
 * 
 * 
 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
 * 
 * var user =User.withUsername("user") .password("dummy12")
 * .passwordEncoder(str-> passwordEncoder().encode(str)) .roles("USER")
 * .build();
 * 
 * var admin =User.withUsername("admin") .password("dummy")
 * .passwordEncoder(str-> passwordEncoder().encode(str)) .roles("ADMIN","USER")
 * .build();
 * 
 * 
 * var jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
 * 
 * jdbcUserDetailsManager.createUser(user);
 * jdbcUserDetailsManager.createUser(admin);
 * 
 * return jdbcUserDetailsManager; }
 * 
 * 
 * @Bean public DataSource dataSource() { return new EmbeddedDatabaseBuilder()
 * .setType(EmbeddedDatabaseType.H2)
 * .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION) .build(); }
 * 
 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
 * new DriverManagerDataSource();
 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
 * dataSource.setUrl("jdbc:mysql://localhost:3306/work");
 * dataSource.setUsername("root"); dataSource.setPassword("password"); return
 * dataSource; }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder();
 * 
 * }
 * 
 * //Create a Key Pair
 * 
 * @Bean public KeyPair keyPair() { try { var keyPairGenerator =
 * KeyPairGenerator.getInstance("RSA"); keyPairGenerator.initialize(2048);
 * //intialize size return keyPairGenerator.generateKeyPair(); } catch(Exception
 * ex) { throw new RuntimeException(ex); } }
 * 
 * //Create RSA key Object
 * 
 * @Bean public RSAKey rsaKey(KeyPair keyPair) { return new RSAKey
 * .Builder((RSAPublicKey) keyPair.getPublic())
 * .privateKey(keyPair.getPrivate()) .keyID(UUID.randomUUID().toString())
 * .build(); }
 * 
 * //create JWK source -->first create jwkset then use that in source
 * 
 * @Bean public JWKSource jwkSource(RSAKey rsaKey) { var jwkSet = new
 * JWKSet(rsaKey);
 * 
 * return (jwkSelector, context)->jwkSelector.select(jwkSet); //Using lambda
 * expression
 * 
 * 
 * new JWKSource() {
 * 
 * @Override public List get(JWKSelector jwkSelector, SecurityContext
 * context)throws KeySourceException { return jwkSelector.select(jwkSet); } }
 * 
 * 
 * }
 * 
 * @Bean public JwtDecoder jwtdecoder(RSAKey rsaKey) throws JOSEException {
 * return NimbusJwtDecoder .withPublicKey(rsaKey.toRSAPublicKey()) .build(); }
 * 
 * 
 * @Bean public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
 * return new NimbusJwtEncoder(jwkSource); }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 */