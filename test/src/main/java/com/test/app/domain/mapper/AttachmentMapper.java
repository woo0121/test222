package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.AttachmentDto;

@Mapper
public interface AttachmentMapper {

    @Insert("INSERT INTO attachment_table (filename, fileurl, user_id) VALUES (#{filename}, #{fileurl}, #{userId})")
    int insertAttachment(AttachmentDto attachmentDto);

    @Update("UPDATE attachment_table SET filename=#{filename}, fileurl=#{fileurl}, user_id=#{userId} WHERE id=#{id}")
    int updateAttachment(Long id, AttachmentDto attachmentDto);

    @Delete("DELETE FROM attachment_table WHERE id=#{id}")
    int deleteAttachment(Long id);

    @Select("SELECT * FROM attachment_table WHERE id=#{id}")
    AttachmentDto selectAttachmentById(Long id);

    @Select("SELECT * FROM attachment_table")
    List<AttachmentDto> selectAllAttachments();

    @Select("SELECT * FROM attachment_table WHERE user_id=#{userId}")
    List<AttachmentDto> selectAttachmentsByUserId(Long userId);
}
