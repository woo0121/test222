package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.CommentDto;

@Mapper
public interface CommentMapper {

    @Insert("INSERT INTO comment_table (content, author_id, post_id) VALUES (#{content}, #{authorId}, #{postId})")
    int insertComment(CommentDto commentDto);

    @Update("UPDATE comment_table SET content=#{content}, author_id=#{authorId}, post_id=#{postId} WHERE id=#{id}")
    int updateComment(CommentDto commentDto);

    @Delete("DELETE FROM comment_table WHERE id=#{id}")
    int deleteComment(Long id);

    @Select("SELECT * FROM comment_table WHERE id=#{id}")
    CommentDto selectCommentById(Long id);

    @Select("SELECT * FROM comment_table WHERE post_id=#{postId}")
    List<CommentDto> selectCommentsByPostId(Long postId);
}
