package com.xdracon.card.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "userId")
    private Long userId;

    @ManyToMany
    @JoinTable(
            name = "cards_shops",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id")
    )
    private Collection<Shop> shops;

    public String getShopName()
    {
        String name=shops.toString();
        return name.substring(name.indexOf("name=") + 5, name.length()-2);
    }
}
