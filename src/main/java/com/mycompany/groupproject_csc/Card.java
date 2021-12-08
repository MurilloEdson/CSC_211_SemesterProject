package com.mycompany.groupproject_csc;

    public class Card {

    private String suit, faceName;

    /**
     * Empty constructor for Card class
     */
    public Card() {
        String suit = "";
        String faceName = "";
    }

    /**
     * @param suit
     * @param faceName
     */
    public Card(String suit, String faceName) {
        this.suit = suit;//Spade,Hearts,Diamonds,Clubs
        this.faceName = faceName;//A,2,3,4,5,6,7,8,9,10,J,Q,K
    }
    
    /**
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * @param faceName
     */
    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    /**
     * @return Card suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return Card faceName
     */
    public String getFaceName() {
        return faceName;
    }

    /**
     * @return faceName and suit in a specific format
     */
    @Override
    public String toString() {
        return (faceName + "_of_" + suit + ".png");
    }
}

