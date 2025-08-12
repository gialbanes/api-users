package com.portfolio.api_users.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import com.portfolio.api_users.infrastructure.entity.Category;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    @JoinColumn(name = "product_id") // na tabela Rating, deve haver uma coluna product_id
    private List<Rating> ratings;
}
