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

import com.test.app.domain.dto.AttachmentDto;
import com.test.app.domain.mapper.AttachmentMapper;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @PostMapping
    public ResponseEntity<?> createAttachment(@RequestBody AttachmentDto attachmentDto) {
        attachmentMapper.insertAttachment(attachmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttachment(@PathVariable Long id, @RequestBody AttachmentDto attachmentDto) {
        attachmentMapper.updateAttachment(id, attachmentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDto> getAttachment(@PathVariable Long id) {
        AttachmentDto attachmentDto = attachmentMapper.selectAttachmentById(id);
        return ResponseEntity.ok(attachmentDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AttachmentDto>> getAllAttachments() {
        List<AttachmentDto> attachments = attachmentMapper.selectAllAttachments();
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AttachmentDto>> getAttachmentsByUserId(@PathVariable Long userId) {
        List<AttachmentDto> attachments = attachmentMapper.selectAttachmentsByUserId(userId);
        return ResponseEntity.ok(attachments);
    }
}
