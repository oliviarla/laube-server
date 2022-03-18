package com.teamk.laube.service;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.user.UserRepository;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public String save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    public List<ReviewResponseDto> findReviews(String id){
        List<Review> list = reviewRepository.findByUser_Id(id);
        return list.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }
}
