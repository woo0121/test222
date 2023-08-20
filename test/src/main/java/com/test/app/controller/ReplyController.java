package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.domain.dto.ReplyDto;
import com.test.app.domain.mapper.ReplyMapper;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyMapper replyMapper;

    @PostMapping
    public ResponseEntity<?> createReply(@RequestBody ReplyDto replyDto) {
        replyMapper.insertReply(replyDto); // 변경
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReply(@PathVariable Long id, @RequestBody ReplyDto replyDto) {
        replyMapper.updateReply(replyDto); // 변경
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReply(@PathVariable Long id) {
    	replyMapper.deleteReply(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<ReplyDto>> getRepliesByCommentId(@PathVariable Long commentId) {
        List<ReplyDto> replies = replyMapper.selectRepliesByCommentId(commentId); // 변경
        return ResponseEntity.ok(replies);
    }
}
