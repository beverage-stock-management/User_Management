package com.beverageStock.user.Service;

import com.beverageStock.user.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    UserDTO getUserById(int userId);
    UserDTO updateUser(UserDTO userDTO, int userId);
    void deleteUser(int userId);


}
