package com.gila.notification.services;

import com.gila.notification.dtos.UserDTO;
import com.gila.notification.entities.User;
import com.gila.notification.exceptions.UserCreationException;
import com.gila.notification.exceptions.UserNotFoundException;
import com.gila.notification.repositories.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        try
        {
            userRepository.save(user);
            return modelMapper.map(user, userDTO.getClass());
        }
        catch (UserCreationException ex) {
            throw new UserCreationException("An error occurred while creating the user.");
        }
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            existingUser.setName(userDTO.getName());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPhoneNumber(userDTO.getPhoneNumber());
            existingUser.setSubscribedCategories(userDTO.getSubscribedCategories());
            existingUser.setNotificationChannels(userDTO.getNotificationChannels());
            User updatedUser = userRepository.save(existingUser);
            return modelMapper.map(updatedUser, UserDTO.class);
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean deleted = false;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }
}
