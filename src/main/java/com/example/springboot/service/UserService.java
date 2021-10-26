package com.example.springboot.service;

import com.example.springboot.dto.UserLocationDTO;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

    }

    private UserLocationDTO convertEntityToDto(User user){
//        we set to loose to make it easier for model mapper to locate and match properties
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return userLocationDTO;

    }

    private User convertDtoToEntity(UserLocationDTO userLocationDTO){
//        we set to loose to make it easier for model mapper to locate and match properties
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userLocationDTO, User.class);
        return user;

    }
}
