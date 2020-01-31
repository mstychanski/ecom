package ecom.pac.service;

import ecom.pac.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
