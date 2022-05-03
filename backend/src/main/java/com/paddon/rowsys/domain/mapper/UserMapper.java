package com.paddon.rowsys.domain.mapper;

import com.paddon.rowsys.config.UserPrincipal;
import com.paddon.rowsys.domain.dto.UserDTO;
import com.paddon.rowsys.domain.model.UserModal;
import com.paddon.rowsys.utils.enums.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDto(UserModal userModal) {
        return this.modelMapper.map(userModal, UserDTO.class);
    }

    public UserModal toModel(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, UserModal.class);
    }

    public static UserPrincipal userPrincipal(UserModal userModal) {
        UserPrincipal user = new UserPrincipal();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userModal.getRole().toString()));


        user.setUsername(userModal.getUsername());
        user.setPassword(userModal.getPassword());
        user.setEnabled(userModal.isEnabled());
        user.setAuthorities(authorities);

        System.out.println(user.isEnabled());

        return user;
    }


}
