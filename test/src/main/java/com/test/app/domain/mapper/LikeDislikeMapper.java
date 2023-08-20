package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.LikeDislikeDto;

@Mapper
public interface LikeDislikeMapper {

    @Insert("INSERT INTO likedislike_table (type, user_id, post_id) VALUES (#{type}, #{userId}, #{postId})")
    int insertLikeDislike(LikeDislikeDto likeDislikeDto);

    @Update("UPDATE likedislike_table SET type=#{type}, user_id=#{userId}, post_id=#{postId} WHERE id=#{id}")
    int updateLikeDislike(LikeDislikeDto likeDislikeDto);

    @Delete("DELETE FROM likedislike_table WHERE id=#{id}")
    int deleteLikeDislike(Long id);

    @Select("SELECT * FROM likedislike_table WHERE id=#{id}")
    LikeDislikeDto selectLikeDislikeById(Long id);

    @Select("SELECT * FROM likedislike_table WHERE user_id=#{userId}")
    List<LikeDislikeDto> selectLikeDislikesByUserId(Long userId);

    @Select("SELECT * FROM likedislike_table WHERE post_id=#{postId}")
    List<LikeDislikeDto> selectLikeDislikesByPostId(Long postId);
}
