package com.test.app.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private Long userId;
    private Long postId;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    // 생성자, getter 및 setter 메소드
}


