package com.test.app.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDto {
	private Long id;
    private String username;
    private String password;
    private String title;
    private String content;
    private String role;
    private Long userId;
    private Long boardId;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private int viewCount;
    private int likes;
    private int dislikes;
    private int commentCount;
}
