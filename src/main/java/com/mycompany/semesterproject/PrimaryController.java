package com.mycompany.semesterproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

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
    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Label score;
    int scored = 0;
    int tries = 0;
    
    
    /**
     * method verifies expression and records game data 
     * 
     **/
    @FXML
    private void verifySolution(ActionEvent event) {

        PostFixNotation pf = new PostFixNotation();
        String expression = (myEquation1.getText());
        String valid = "Valid Expression";
        String inValid = "Not Valid Expression";

        try {

            if (pf.evaluate(expression) == 24) {
                myEquation2.setText(valid);
                scored++;
                score.setText("Score: " + scored);
            } else if (pf.evaluate(expression) != 24) {
                myEquation2.setText(inValid);
            }

            FileWriter file = new FileWriter("gamelogs.txt", true);
            BufferedWriter write = new BufferedWriter(file);
            PrintWriter pWrite = new PrintWriter(write);

            tries++;
            pWrite.println("Card-24 Game Computer Validation Test: " + tries + "--------");
            pWrite.println("User typed: " + expression);
            if (pf.evaluate(expression) == 24) {
                pWrite.println("Computer computes expression is..." + valid);
                pWrite.println("Score is: " + scored);
            } else if (pf.evaluate(expression) != 24) {
                pWrite.println("Computer computes expression is..." + inValid);
                pWrite.println("Score remains: " + scored);
            } else {
                pWrite.println("Computer can't compute...empty expression");
            }

            pWrite.close();
            write.close();
            file.close();

        } catch (IOException io) {

        } catch (EmptyStackException e) {
            myEquation2.setText("Empty: Not Valid");

        }
    }
    
    /**
     * 
     * method determines alternate solution  
     */
    @FXML
    private void fIndSolution(ActionEvent event) {

    }
    
    /**
     * 
     * method displays cards to screen 
     */
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

        rect1.setVisible(true);
        rect2.setVisible(true);
        rect3.setVisible(true);
        rect4.setVisible(true);

    }

}
