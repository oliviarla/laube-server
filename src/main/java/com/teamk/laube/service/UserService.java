package com.teamk.laube.service;

import com.teamk.laube.domain.user.UserRepository;
import com.teamk.laube.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }
}
