package com.test.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDto {
    private Long id;
    private Long postId;
    private Long userId;

    // 생성자, getter 및 setter 메소드
}
