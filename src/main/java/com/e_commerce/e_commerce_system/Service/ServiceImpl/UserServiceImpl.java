package com.e_commerce.e_commerce_system.Service.ServiceImpl;

import com.e_commerce.e_commerce_system.DTOs.UserDTO;
import com.e_commerce.e_commerce_system.Modules.User;
import com.e_commerce.e_commerce_system.Repository.UserRepository;
import com.e_commerce.e_commerce_system.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
         User user = new User();
         user.setName(userDTO.getName());
         user.setEmail(userDTO.getEmail());
         User savedUser = userRepository.save(user);

         return UserDTO.builder()
                 .id(savedUser.getId())
                 .email(savedUser.getEmail())
                 .name(savedUser.getName())
                 .build();
    }
}
