package com.xdracon.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdracon.card.dtos.CardDto;
import com.xdracon.card.entities.Card;
import com.xdracon.card.repositories.CardRepository;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;


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

    public static void audit(String str){
        try {
            URL url = new URL("http://localhost:8082/audit");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String params = "INFO=" + str;
            byte[] postData = params.getBytes(StandardCharsets.UTF_8);

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Card> findByUserId(Long id) {
        audit("List of cards sent");
        return cardRepository.findByUserId(id);
    }

    public Card createNewCard(CardDto cardDto) {
        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setShops(List.of(shopService.getCardShop(cardDto.getShopName())));
        card.setUserId(cardDto.getUserId());
        audit("Card added");
        return cardRepository.save(card);
    }
}
