package com.test.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.app.domain.dto.AppDto;

@Mapper
public interface AppMapper {
    
	 @Select("SELECT * FROM boards LIMIT #{offset}, #{pageSize}")
	    List<AppDto> selectAllBoards(@Param("offset") int offset, @Param("pageSize") int pageSize);
	
    @Update("UPDATE boards SET likes = likes + 1 WHERE id = #{id}")
    void likeBoard(Long id);

    @Update("UPDATE boards SET dislikes = dislikes + 1 WHERE id = #{id}")
    void dislikeBoard(Long id);

    @Insert("INSERT INTO comments (board_id, writer, content) VALUES (#{boardId}, #{writer}, #{content})")
    void createComment(AppDto comment);
  
    @Insert("INSERT INTO users (username, password, email) VALUES (#{username}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(AppDto appDto);

	    @Update("UPDATE user_table SET password=#{password}, role_id=#{roleId} WHERE username=#{username}")
	    int updateUser(AppDto appDto);

	    @Delete("DELETE FROM user_table WHERE username=#{username}")
	    int deleteUser(String username);

	    @Select("SELECT * FROM user_table WHERE username=#{username}")
	    AppDto selectUserByUsername(String username);

	    @Select("SELECT * FROM user_table")
	    List<AppDto> selectAllUsers();

	    @Select("SELECT * FROM user_table INNER JOIN role_table ON user_table.role_id = role_table.id WHERE user_table.username=#{username}")
	    AppDto selectUserWithRole(String username);
}
    // Board 관련 쿼리

//@Select(
//        "SELECT u.*, r.role_name " +
//        "FROM users u " +
//        "JOIN user_role ur ON u.id = ur.user_id " +
//        "JOIN roles r ON r.id = ur.role_id " +
//        "WHERE u.username = #{username}")
//AppDto selectUserWithRole(String username);
