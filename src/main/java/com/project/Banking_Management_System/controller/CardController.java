package com.project.Banking_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.service.CardService;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;
@RestController
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@PostMapping("/saveCard")
	public ResponseStructure<Card> saveCard(@RequestBody Card card)
	{
		return cardService.saveCard(card);
	}
	
	@GetMapping("/fetchCardById")
	public ResponseStructure<Card> fetchCardById(@RequestParam int cardId)
	{
		return cardService.fetchCardById(cardId);
	}
	
	@PutMapping("/updateCard")
	public ResponseStructure<Card> updateCard(@RequestBody Card card,@RequestParam int oldCardId)
	{
		card.setCardId(oldCardId);
		return cardService.saveCard(card);
	}
	
	@DeleteMapping("/deleteCard")
	public ResponseStructure<Card> deleteCard(@RequestParam int cardId) {
		return cardService.deleteCard(cardId);
	}
	
	@GetMapping("/fetchAllCard")
	public ResponseStructureList<Card> fetchAllCard() {
		return cardService.fetchAllCard();
	}

}
