package com.test.security.Service;

import com.test.security.Model.User;
import com.test.security.Model.UserInfo;
import com.test.security.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

    private final UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= repo.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserInfo(user);
    }
}
