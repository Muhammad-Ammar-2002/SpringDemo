package com.SpringDemo.Security.Service;

import com.SpringDemo.Exceptions.DuplicateRecordException;
import com.SpringDemo.Security.Model.User;
import com.SpringDemo.Security.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepo repo;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(User user)  {
        if (repo.findByUsername(user.getUsername())!=null) {
            throw new DuplicateRecordException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
