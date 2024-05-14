package com.xdracon.card.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.xdracon.card.entities.Shop;

@Data
@AllArgsConstructor
public class CardDto {
    private Long id;
    private Long number;
    private Long userId;
    private String shopName;
}
