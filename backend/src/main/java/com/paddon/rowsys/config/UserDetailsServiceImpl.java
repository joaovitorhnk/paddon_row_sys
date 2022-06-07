package com.paddon.rowsys.config;

import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.mapper.UserMapper;
import com.paddon.rowsys.domain.model.UserModal;
import com.paddon.rowsys.repositories.UserRepository;
import javax.transaction.Transactional;

import com.paddon.rowsys.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModal user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
        return UserMapper.userPrincipal(user);
    }
}
