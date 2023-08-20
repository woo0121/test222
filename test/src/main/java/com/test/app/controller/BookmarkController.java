package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.domain.dto.BookmarkDto;
import com.test.app.domain.mapper.BookmarkMapper;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkMapper bookmarkMapper;

    @PostMapping
    public ResponseEntity<?> createBookmark(@RequestBody BookmarkDto bookmarkDto) {
        bookmarkMapper.insertBookmark(bookmarkDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBookmark(@RequestBody BookmarkDto bookmarkDto) {
        bookmarkMapper.deleteBookmark(bookmarkDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookmarkDto>> getBookmarksByUserId(@PathVariable Long userId) {
        List<BookmarkDto> bookmarks = bookmarkMapper.selectBookmarksByUserId(userId);
        return ResponseEntity.ok(bookmarks);
    }
}
