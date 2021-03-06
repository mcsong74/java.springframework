package com.cybertek.security;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//implementation of UserDetailsService
//Spring requires below override the methods of UserDetailsService interface
@Service
public class UserPrincipalDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);  //get user from db
        if (user == null) {
            throw new UsernameNotFoundException("User does not exists");
        }
        UserPrincipal userPrincipal = new UserPrincipal(user);   //converts user obj to user details obj
        return userPrincipal;
    }
}
