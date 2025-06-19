package com.api.monster_shop.models;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private double rating;

    @Column (nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    public Review() {
    }

    public Review(Long id, String username, double rating, String body, Product product) {
        this.id = id;
        this.username = username;
        this.rating = rating;
        this.body = body;
        this.product = product;
    }

    public Review(Long productId, String username, double rating, String body) {
        this.id = productId;
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}

