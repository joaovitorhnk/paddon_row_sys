package com.paddon.rowsys.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "role")
@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;


}
