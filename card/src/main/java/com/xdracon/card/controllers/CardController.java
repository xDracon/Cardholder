package com.xdracon.card.controllers;

import com.xdracon.card.entities.Card;
import com.xdracon.card.repositories.CardRepository;
import com.xdracon.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.xdracon.card.dtos.CardDto;
import com.xdracon.card.service.AuthService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CardController {
    private final AuthService authService;
    private final CardService cardService;
    @Autowired
    private final CardRepository cardRepository;

    @RequestMapping("/card/add")
    public String showAddForm() {
        return "addCard";
    }

    @PostMapping("/card/add")
    public String createNewCard(@RequestBody CardDto cardDto) {
        authService.createNewCard(cardDto);
        return "addCard";
    }

    @GetMapping("card/all/{id}")
    public String viewCards (@PathVariable Long id, Model model) {
        List <Card> list = cardService.findByUserId(id);
        model.addAttribute("cards", list);
        //model.addAttribute("shop",card.getShops());
        return "cardsPage";
    }
}