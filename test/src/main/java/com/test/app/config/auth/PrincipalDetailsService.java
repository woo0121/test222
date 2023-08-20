package com.test.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.AppDto;
import com.test.app.domain.mapper.AppMapper;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AppMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppDto dto = userMapper.selectUserWithRole(username);

        if (dto == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        return new PrincipalDetails(dto);
    }
}
