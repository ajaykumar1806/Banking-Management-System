package com.project.Banking_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.Banking_Management_System.dao.CardDao;
import com.project.Banking_Management_System.dto.Card;
import com.project.Banking_Management_System.exception.CardIdNotFound;
import com.project.Banking_Management_System.util.ResponseStructure;
import com.project.Banking_Management_System.util.ResponseStructureList;

@Service
public class CardService {
	
	@Autowired
	CardDao cardDao;
	
	@Autowired
	ResponseStructure<Card> responseStructure;
	
	@Autowired
	ResponseStructureList<Card> responseStructureList;
	
	public ResponseStructure<Card> saveCard(Card card)
	{
		responseStructure.setMessage("Successfully Inserted Card Into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return responseStructure;
	}
	
	public ResponseStructure<Card> fetchCardById(int cardId)
	{
		Card card=cardDao.fetchCardById(cardId);
		if(card!=null) {
			responseStructure.setMessage("Successfully Fetched Card From DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(card);
			return responseStructure;
		}
		else throw new CardIdNotFound();
	}
	
	public ResponseStructure<Card> updateCard(Card card,int oldCardId)
	{
		Card oldCard=cardDao.fetchCardById(oldCardId);
		if(oldCard!=null) {
			responseStructure.setMessage("Successfully Updated Card Into DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			card.setCardId(oldCardId);
			responseStructure.setData(cardDao.updateCard(card, oldCardId));
			return responseStructure;
		}
		else throw new CardIdNotFound();
	}
	
	public ResponseStructure<Card> deleteCard(int cardId) {
		Card card=cardDao.fetchCardById(cardId);
		if(card!=null) {
			responseStructure.setMessage("Successfully Deleted Card From DataBase");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(cardDao.deleteCard(cardId));
			return responseStructure;
		}
		else throw new CardIdNotFound();
	}
	
	public ResponseStructureList<Card> fetchAllCard() {
		List<Card> cards=cardDao.fetchAllCard();
		if(cards.size()==0) {
			responseStructureList.setMessage("Successfully Fetched Cards From DataBase");
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setData(cards);
			return responseStructureList;
		}
		else throw new CardIdNotFound();
	}

}
