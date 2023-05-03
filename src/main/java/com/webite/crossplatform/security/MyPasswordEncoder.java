//package com.webite.crossplatform.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class MyPasswordEncoder implements PasswordEncoder {
//
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return encoder.encode(rawPassword);
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return encoder.matches(rawPassword, encodedPassword);
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new MyPasswordEncoder();
//    }
//}
