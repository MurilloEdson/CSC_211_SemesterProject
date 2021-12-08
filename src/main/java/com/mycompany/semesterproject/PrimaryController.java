package com.mycompany.semesterproject;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private TextField myEquation1;
    @FXML
    private TextField myEquation2;
    @FXML
    private ImageView Card1;
    @FXML
    private ImageView Card2;
    @FXML
    private ImageView Card3;
    @FXML
    private ImageView Card4;
    
    Timer jp = new Timer();

    @FXML
    private void verifySolution(ActionEvent event) {
        PostFixNotation pf =  new PostFixNotation();
        String expression = (myEquation1.getText());
        
        if (pf.evaluate(expression) == 24){
            myEquation1.setText(expression + " = 24, Valid Expression ");
        }
        else if (pf.evaluate(expression) != 24){
            myEquation1.setText(expression +  " is not = 24, Not Valid Expression");
        }
       
    }

    @FXML
    private void fIndSolution(ActionEvent event) {

    }

    @FXML
    private void refreshCards(ActionEvent event) {
        Deck deck = new Deck();

        Image image = new Image("/cards/" + deck.getCard() + ".png");
        Card1.setImage(image);

        Image image2 = new Image("/cards/" + deck.getCard() + ".png");
        Card2.setImage(image2);

        Image image3 = new Image("/cards/" + deck.getCard() + ".png");
        Card3.setImage(image3);

        Image image4 = new Image("/cards/" + deck.getCard() + ".png");
        Card4.setImage(image4);

    }

}
