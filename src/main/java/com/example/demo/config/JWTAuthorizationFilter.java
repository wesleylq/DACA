package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.services.LozUserService;
import com.example.demo.utils.SecurityConstants;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private final LozUserService lozUserService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, LozUserService lozUserService) {
		super(authenticationManager);
		this.lozUserService = lozUserService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain chain) throws IOException, ServletException{
		String header = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if(header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		if(token == null) return null;
		
		String username = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
				.getBody()
				.getSubject();
		
		UserDetails userDetails = lozUserService.loadUserByUsername(username);
		return username != null ? 
				new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities()) : null;	
	}
}