package com.mycompany.semesterproject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    
    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit()  {
        System.out.println("getSuit");
        Card instance = new Card();//creating Card object
        String expResult = "spades";
        instance.setSuit("spades");//setting suit
        String result = instance.getSuit();
        assertEquals(expResult, result);//see's if there is a match
    }

    /**
     * Test of getFaceName method, of class Card.
     */
    @Test
    public void testGetFaceName()  {
        System.out.println("getFaceName");
        Card instance = new Card();//creating Card object
        String expResult = "ace";
        instance.setFaceName("ace");//setting FaceName
        String result = instance.getFaceName();
        assertEquals(expResult, result);//see's if there is a match
        
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card();//creating Card object
        instance.setFaceName("ace");//setting suit
        instance.setSuit("spades");//setting FaceName
        String expResult = "ace_of_spades";
        assertEquals(expResult, instance.toString());//see's if there is a match
       
    }
    
}
