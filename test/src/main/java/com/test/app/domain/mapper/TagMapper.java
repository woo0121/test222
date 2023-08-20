package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.TagDto;

@Mapper
public interface TagMapper {

    @Insert("INSERT INTO tag_table (name) VALUES (#{name})")
    int insertTag(TagDto tagDto);

    @Update("UPDATE tag_table SET name=#{name} WHERE id=#{id}")
    int updateTag(TagDto tagDto);

    @Delete("DELETE FROM tag_table WHERE id=#{id}")
    int deleteTag(Long id);

    @Select("SELECT * FROM tag_table WHERE id=#{id}")
    TagDto selectTagById(Long id);

    @Select("SELECT * FROM tag_table")
    List<TagDto> selectAllTags();
    
    @Select("SELECT * FROM tag_table WHERE name=#{tagName}")
    List<TagDto> selectTagsByName(String tagName);
}
