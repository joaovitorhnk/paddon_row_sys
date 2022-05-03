package com.paddon.rowsys.utils.converters;

import com.paddon.rowsys.utils.enums.Role;

import javax.persistence.AttributeConverter;

public class RoleEnumConverter implements AttributeConverter<Role, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Role role) {
        if(role == null) {
            return null;
        } else {
            switch (role) {
                case ADMIN:
                    return 1;
                case USER:
                    return 2;
                default:
                    throw new IllegalArgumentException(role + " not supported.");
            }
        }
    }

    @Override
    public Role convertToEntityAttribute(Integer integer) {
        if(integer == null) {
            return null;
        } else {
            switch (integer) {
                case 1:
                    return Role.ADMIN;
                case 2:
                    return Role.USER;
                default:
                    throw new IllegalArgumentException(integer + " not supported.");
            }
        }
    }
}
