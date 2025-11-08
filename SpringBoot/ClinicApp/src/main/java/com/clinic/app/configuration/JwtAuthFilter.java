package com.clinic.app.configuration;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.clinic.app.services.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private CustomUserDetailService userDetailsService;

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getServletPath();
		return path.startsWith("/auth/login"); // ✅ Skip JWT validation for login/register
	}

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		final String authHeader = request.getHeader("Authorization");
//		String token = null;
//		String username = null;
//
//		// ✅ Check if Authorization header contains a Bearer token
//		if (authHeader != null && authHeader.startsWith("Bearer ")) {
//			token = authHeader.substring(7); // Remove "Bearer "
//			username = jwtUtils.extractUsername(token);
//		}
//
//		// ✅ Authenticate only if username is valid and not already authenticated
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//			if (jwtUtils.isTokenValid(token, userDetails)) {
//
//				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
//						null, userDetails.getAuthorities());
//
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//				SecurityContextHolder.getContext().setAuthentication(authToken);
//			}
//		}
//
//		filterChain.doFilter(request, response);
//	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtUtils.extractUsername(token);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			System.out.println("🟢 Username from token: " + username);
			System.out.println("🟢 Checking token validity for: " + userDetails.getUsername());
			if (jwtUtils.isTokenValid(token, userDetails)) {
				System.out.println("🟢 Token validated successfully!");
				// ✅ Extract role from token claim
				String role = jwtUtils.extractAllClaims(token).get("role", String.class);

				// ✅ Build authority from role
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
				List<SimpleGrantedAuthority> authorities = List.of(authority);
				
				

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, authorities);

				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authToken);
				
				
			}
		}

		filterChain.doFilter(request, response);
	}

}
