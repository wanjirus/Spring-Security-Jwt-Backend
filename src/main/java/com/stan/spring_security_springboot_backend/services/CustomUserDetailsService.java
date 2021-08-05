package com.stan.spring_security_springboot_backend.services;

import com.stan.spring_security_springboot_backend.entity.User;
import com.stan.spring_security_springboot_backend.interfaces.CustomUserDetails;
import com.stan.spring_security_springboot_backend.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
   private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
        throw new UsernameNotFoundException("user not found");

        }

        return new CustomUserDetails(user);
    }
}
