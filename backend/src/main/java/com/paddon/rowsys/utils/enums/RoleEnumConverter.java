package com.paddon.rowsys.utils.enums;

import javax.persistence.AttributeConverter;

public class RoleEnumConverter implements AttributeConverter<Role, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Role role) {
        if(role == null) {
            return null;
        } else {
            switch (role) {
                case ADMIN_SYSTEM:
                    return 1;
                case USER_COMMON:
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
                    return Role.ADMIN_SYSTEM;
                case 2:
                    return Role.USER_COMMON;
                default:
                    throw new IllegalArgumentException(integer + " not supported.");
            }
        }
    }
}
