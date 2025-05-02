package com.test.security.Security.Service;

import com.test.security.Exceptions.DuplicateRecordException;
import com.test.security.Security.Model.User;

public interface UserServiceInterface {
    User save(User user) ;
}
