package com.beverageStock.user.Service;

import com.beverageStock.user.DTO.UserDTO;
import com.beverageStock.user.Model.User;
import com.beverageStock.user.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setUserPosition(user.getUserPosition());

        User newUser = userRepo.save(user);
        UserDTO userResponse = new UserDTO();
        userResponse.setUserId(newUser.getUserId());
        userResponse.setUserName(newUser.getUserName());
        userResponse.setUserPosition(newUser.getUserPosition());

        return userResponse;
    }

    @Override
    public List<UserDTO> getAllUser(){
        List<User> user = userRepo.findAll();
        return user.stream().map(p -> mapToDTO(p)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user = userRepo.findById(userId);
        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int userId) {
        User user = userRepo.findById(userId);

        user.setUserName(userDTO.getUserName());
        user.setUserPosition(userDTO.getUserPosition());

        User updatedUser = userRepo.save(user);
        return mapToDTO (updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepo.findById(userId);
        userRepo.delete(user);
    }

    private UserDTO mapToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(userDTO.getUserName());
        userDTO.setUserPosition(user.getUserPosition());
        return userDTO;
    }

    private User mapToEntity(UserDTO userDTO){
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setUserPosition(userDTO.getUserPosition());
        return user;
    }
}
