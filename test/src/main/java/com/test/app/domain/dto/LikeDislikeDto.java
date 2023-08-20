package com.test.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDislikeDto {
    private Long id;
    private Long postId;
    private Long userId;
    private boolean isLike;

    // 생성자, getter 및 setter 메소드
}

