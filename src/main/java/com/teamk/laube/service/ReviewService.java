package com.teamk.laube.service;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.dto.ReviewRequestDto;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.exception.CustomException;
import com.teamk.laube.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    /**
     * 리뷰 생성
     */
    @Transactional
    public Long save(final ReviewRequestDto params){
        Review entity= reviewRepository.save(params.toEntity());
        System.out.println(entity.getMember().getId());
        return entity.getId();
    }
    /**
     * 모든 리뷰 리스트 조회
     */
    public List<ReviewResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "regdate");
        List<Review> list = reviewRepository.findAll(sort);
        return list.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 리뷰 아이디로 조회
     */
    public Optional<ReviewResponseDto> findById(Long id){
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(ReviewResponseDto::new);
    }

    /**
     * 향수 아이디로 작성된 리뷰 조회
     */
    public List<ReviewResponseDto> findByPerfumeId(Long id){
        List<Review> list = reviewRepository.findByPerfume_Id(id);
        return list.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 리뷰 수정
     */
    public Long update(final Long id, final ReviewRequestDto params){
        Review entity= reviewRepository.findById(id).orElseThrow(()->new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getContent(), params.getMember());
        reviewRepository.save(entity);
        return entity.getId();
    }
}
