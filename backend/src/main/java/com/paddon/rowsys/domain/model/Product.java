package com.paddon.rowsys.domain.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "image")
    private Byte[] image;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String[] size;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Double price;

    @OneToOne(mappedBy = "product")
    private User user;




}
