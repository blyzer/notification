package com.gila.notification.services;

import com.gila.notification.dtos.UserDTO;

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
     * Update a new user.
     *
     * @param id The id of user
     * @param user The user data.
     * @return The created user.
     */
    UserDTO updateUser(long id, UserDTO user);

    /**
     * Get a User by id.
     *
     * @param id The user id.
     * @return UserDTO
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
