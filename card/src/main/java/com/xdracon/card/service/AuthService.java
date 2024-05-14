package com.xdracon.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.xdracon.card.dtos.CardDto;
import com.xdracon.card.entities.Card;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CardService cardService;

    public void createNewCard(@RequestBody CardDto cardDto) {
        Card card = cardService.createNewCard(cardDto);
    }
}
