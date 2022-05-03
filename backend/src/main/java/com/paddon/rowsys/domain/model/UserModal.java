package com.paddon.rowsys.domain.model;

import com.paddon.rowsys.utils.enums.Role;
import com.paddon.rowsys.utils.converters.RoleEnumConverter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Data
public class UserModal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    @Convert(converter = RoleEnumConverter.class)
    @Column(name = "role_id")
    private Role role;

}