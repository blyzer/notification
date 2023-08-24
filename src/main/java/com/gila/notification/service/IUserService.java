package com.gila.notification.service;

import com.gila.notification.dto.UserDTO;

import java.util.List;

public interface IUserService {
    /**
     * Create a new user.
     *
     * @param user The user data.
     * @return The created user.
     */
    UserDTO createUser(UserDTO user);

    /**
     * Get a User by id.
     *
     * @param id The user id.
     * @return
     */
    UserDTO getUserById(Long id);

    /**
     * Get all users.
     *
     * @return All Users.
     */
    List<UserDTO> getAllUsers();

    /**
     * Delete user by id.
     *
     * @param id The user id.
     * @return True if removed and false if no.
     */
    boolean deleteUser(Long id);
}
