package com.mycompany.groupproject_csc;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Card { //Deck class inherits method from Card class 

    private final String faceName[] = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};//cards faceName
    private final String suit[] = {"hearts", "diamonds", "spades", "clubs"}; //cards suits
    private ArrayList<Card> deck; //deck holds Card objects

    /**
     * Empty Constructor for Deck class
     */
    public Deck() {
    }

    /**
     * creates Deck using Card objects
     */
    public void createDeck() {
        deck = new ArrayList<Card>();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < faceName.length; j++) {
                deck.add(new Card(suit[i], faceName[j]));
            }
        }
    }

    /**
     * calls createDeck method and shuffles deck
     */
    public void shuffle() {
        createDeck();
        Collections.shuffle(deck);
    }

    /**
     * @return a card from a shuffled deck
     */
    public String getCard() {
        shuffle();
        String card = "";
        for (int i = 0; i < 1; i++) {
            card += deck.get(i).toString();
        }
        return card;
    }
}