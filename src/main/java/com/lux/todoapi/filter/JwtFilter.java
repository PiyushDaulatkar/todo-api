package com.lux.todoapi.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import javax.crypto.SecretKey;

@Component
public class JwtFilter extends OncePerRequestFilter {

        @Value("${jwt.secret}")
        private String jwtSecret;

        // TODO: Move this to a utility class or JWT service to avoid code duplication.
        private SecretKey getKey() {
                byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
                return Keys.hmacShaKeyFor(keyBytes);
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                        HttpServletResponse response,
                        FilterChain filterChain) throws ServletException, IOException {

                String authHeader = request.getHeader("Authorization");

                if (authHeader != null && authHeader.startsWith("Bearer ")) {

                        String token = authHeader.substring(7);

                        try {
                                Claims claims = Jwts.parser()
                                                .verifyWith(getKey())
                                                .build()
                                                .parseSignedClaims(token)
                                                .getPayload();

                                String userId = claims.getSubject();

                                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                                userId,
                                                null,
                                                Collections.emptyList());

                                authentication.setDetails(
                                                new WebAuthenticationDetailsSource().buildDetails(request));

                                SecurityContextHolder.getContext()
                                                .setAuthentication(authentication);
                        } catch (Exception e) {
                                // Invalid token → ignore, request will be unauthenticated
                        }
                }

                filterChain.doFilter(request, response);
        }
}
