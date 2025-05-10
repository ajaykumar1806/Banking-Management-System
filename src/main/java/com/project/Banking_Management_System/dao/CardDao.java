package com.project.Banking_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.repo.CardRepo;
@Repository
public class CardDao {
	
	@Autowired
	CardRepo cardRepo;
	
	public Card saveCard(Card card)
	{
		return cardRepo.save(card);
	}
	
	public Card fetchCardById(int cardId)
	{
		Optional<Card> card=cardRepo.findById(cardId);
		return (card.isPresent()) ? card.get() : null;
	}
	
	public Card updateCard(Card card,int oldCardId)
	{
		card.setCardId(oldCardId);
		return cardRepo.save(card);
	}
	
	public Card deleteCard(int cardId) {
		Card card=fetchCardById(cardId);
		cardRepo.deleteById(cardId);
		return card;
	}
	
	public List<Card> fetchAllCard() {
		return cardRepo.findAll();
	}
	

}
