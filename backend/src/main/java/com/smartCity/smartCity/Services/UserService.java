package com.smartCity.smartCity.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartCity.smartCity.Entities.User;
import com.smartCity.smartCity.Repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Long id, User user){
        // Check if the user exists
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {

            User updatedUser = existingUser.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        User foundUser = user.get();
        userRepository.delete(foundUser);      
    }
}
