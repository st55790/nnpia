package cz.upce.fei.cv01.service;

import cz.upce.fei.cv01.domain.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

@Service
@AllArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private AppUserService appUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserService.findByName(username);

        if(appUser == null) throw new UsernameNotFoundException("User not found with username: " + username);

        return new User(appUser.getUsername(), appUser.getPassword(), new ArrayList<>());
    }
}
