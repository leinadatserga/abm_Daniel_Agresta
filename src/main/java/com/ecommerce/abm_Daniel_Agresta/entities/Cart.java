package com.ecommerce.abm_Daniel_Agresta.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long cartId;

    @Getter @Setter private Integer amount;

    @Getter @Setter private Double price;

    @ManyToMany
    @JoinTable(
            name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference("cart-products")
    @Getter @Setter private List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference("client-carts")
    @Getter @Setter private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @Getter @Setter private Invoice invoice;

}
