package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.LozUser;
import com.example.demo.repositories.LozUserRepository;


@Service
@Transactional
public class LozUserService  implements UserDetailsService{
	
	@Autowired
	private LozUserRepository clientRepository;

	public List<LozUser> getClients() {
		return clientRepository.findAll();
	}

	public LozUser getClient(String id) {
		return clientRepository.findClientById(id);
	}
	
	public void addClient(LozUser client) {
		clientRepository.save(client);
		
	}

	public void deleteClient(int id) {
		clientRepository.deleteById(id);
		
	}

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        LozUser user = clientRepository.findByUsername(username);
	        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
	        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
	        return new org.springframework.security.core.userdetails.User
	                (user.getUsername(), user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);

	    }

	

	
}
