//package com.webite.crossplatform.security;
//
//import jakarta.servlet.FilterChain;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//
//@Component
//public class JwtAthFilter extends OncePerRequestFilter {
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Override
//    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
//        final String authHeader = request.getHeader(AUTHORIZATION);
//        final String userEmail;
//        final String jwtToken;
//
//        if(authHeader == null || !authHeader.startsWith("Bearer")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        jwtToken = authHeader.substring(7);
//        userEmail = "email";
//        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//            final boolean isTokenValid;
//            if(isTokenValid) {
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//
//    }
//}
