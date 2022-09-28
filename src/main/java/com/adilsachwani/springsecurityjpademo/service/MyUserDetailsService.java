package com.adilsachwani.springsecurityjpademo.service;

import com.adilsachwani.springsecurityjpademo.model.MyUserDetails;
import com.adilsachwani.springsecurityjpademo.model.User;
import com.adilsachwani.springsecurityjpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new MyUserDetails(user.get());
    }

}
