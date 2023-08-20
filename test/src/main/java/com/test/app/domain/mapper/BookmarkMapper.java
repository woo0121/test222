package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.test.app.domain.dto.BookmarkDto;

@Mapper
public interface BookmarkMapper {

    @Insert("INSERT INTO bookmark_table (post_id, user_id) VALUES (#{postId}, #{userId})")
    int insertBookmark(BookmarkDto bookmarkDto);

    @Delete("DELETE FROM bookmark_table WHERE post_id=#{postId} AND user_id=#{userId}")
    int deleteBookmark(BookmarkDto bookmarkDto);

    @Select("SELECT * FROM bookmark_table WHERE post_id=#{postId} AND user_id=#{userId}")
    BookmarkDto selectBookmark(BookmarkDto bookmarkDto);

    @Select("SELECT * FROM bookmark_table WHERE user_id=#{userId}")
    List<BookmarkDto> selectBookmarksByUserId(Long userId);
}
