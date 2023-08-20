package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.ReplyDto;

@Mapper
public interface ReplyMapper {

    @Insert("INSERT INTO reply_table (content, user_id, comment_id) VALUES (#{content}, #{userId}, #{commentId})")
    int insertReply(ReplyDto replyDto);

    @Update("UPDATE reply_table SET content=#{content}, user_id=#{userId}, comment_id=#{commentId} WHERE id=#{id}")
    int updateReply(ReplyDto replyDto);

    @Delete("DELETE FROM reply_table WHERE id=#{id}")
    int deleteReply(Long id);

    @Select("SELECT * FROM reply_table WHERE id=#{id}")
    ReplyDto selectReplyById(Long id);

    @Select("SELECT * FROM reply_table WHERE comment_id=#{commentId}")
    List<ReplyDto> selectRepliesByCommentId(Long commentId);
}
