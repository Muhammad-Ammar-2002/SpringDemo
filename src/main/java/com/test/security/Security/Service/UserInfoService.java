package com.test.security.Security.Service;

import com.test.security.Security.Model.User;
import com.test.security.Security.Model.UserInfo;
import com.test.security.Security.Repository.UserRepo;
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

        if (user==null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new UserInfo(user);
    }


}
