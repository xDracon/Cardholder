package com.xdracon.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.xdracon.card.entities.Shop;
import com.xdracon.card.repositories.ShopRepository;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop getCardShop(String name) {
        return shopRepository.findByName(name).get();
    }
}
