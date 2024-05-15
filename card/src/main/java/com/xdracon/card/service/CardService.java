package com.xdracon.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdracon.card.dtos.CardDto;
import com.xdracon.card.entities.Card;
import com.xdracon.card.repositories.CardRepository;

import java.util.List;

import static com.xdracon.card.CardApplication.log;

@Service
public class CardService {
    private CardRepository cardRepository;
    private ShopService shopService;

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<Card> findByUserId(Long id) {
        log.info("Отправлен список карт");
        return cardRepository.findByUserId(id);
    }

    public Card createNewCard(CardDto cardDto) {
        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setShops(List.of(shopService.getCardShop(cardDto.getShopName())));
        card.setUserId(cardDto.getUserId());
        log.info("Карта добавлена");
        return cardRepository.save(card);
    }
}
