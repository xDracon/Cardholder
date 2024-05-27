package com.xdracon.card.controllers;

import com.xdracon.card.entities.Card;
import com.xdracon.card.repositories.CardRepository;
import com.xdracon.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.xdracon.card.dtos.CardDto;
import com.xdracon.card.service.TransferService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CardController {
    private final TransferService transferService;
    private final CardService cardService;
    @Autowired
    private final CardRepository cardRepository;

    @RequestMapping("/card/add")
    public String showAddForm() {
        return "addCard";
    }

    @PostMapping("/card/save")
    public String createNewCard(@RequestBody CardDto cardDto) {
        transferService.createNewCard(cardDto);
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