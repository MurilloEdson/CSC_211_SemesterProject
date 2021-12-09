package com.mycompany.groupproject_csc;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PrimaryController{
    
    @FXML
    private ImageView card1;
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    @FXML
    private ImageView card4;
    @FXML
    private TextField userInput;
    @FXML
    private TextField gameOutput;
    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Button mainB;
    @FXML
    private Label clock;
    int seconds = 0;
    int minutes = 0;
    String time = "" + minutes +":"+ seconds;
    boolean stop = false;
    int start = 0;
    int tries = 0;
    Timeline timeline;
    @FXML
    private Label score;
    int scored = 0;
    
    @FXML
    private void refresh(ActionEvent event) throws FileNotFoundException {
        
        start++;
        seconds = 0;
        minutes = 0;
        clock.setText("Time :" + minutes + ":" + seconds);
        Deck deck = new Deck();
        if (start > 0 ){
            mainB.setText("Refresh");}

        Image image = new Image(new FileInputStream("C:\\Users\\Edson\\OneDrive\\Pictures\\PlayingCards\\png\\" + deck.getCard()));
        card1.setImage(image);

        Image image2 = new Image(new FileInputStream("C:\\Users\\Edson\\OneDrive\\Pictures\\PlayingCards\\png\\" + deck.getCard()));
        card2.setImage(image2);

        Image image3 = new Image(new FileInputStream("C:\\Users\\Edson\\OneDrive\\Pictures\\PlayingCards\\png\\" + deck.getCard()));
        card3.setImage(image3);

        Image image4 = new Image(new FileInputStream("C:\\Users\\Edson\\OneDrive\\Pictures\\PlayingCards\\png\\" + deck.getCard()));
        card4.setImage(image4);
        rect1.setVisible(true);
        rect2.setVisible(true);
        rect3.setVisible(true);
        rect4.setVisible(true);
        
        KeyFrame count = new KeyFrame(Duration.millis(1000),(t) -> {
            seconds++;
            if (seconds > 60){
                minutes++;
                seconds = seconds - 60;
            }
            clock.setText("Time : "+ minutes + ":"+ seconds);
        });
        timeline = new Timeline(count);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        gameOutput.setText("");
        userInput.setText("");
    }
    
    @FXML
    void verify(ActionEvent event){
        Verification pf =  new Verification();
        String valid = "Valid Expression";
        String invalid ="Not Valid Expression";
        String expression = (userInput.getText());
        try {
        
        if (pf.evaluate(expression) == 24){
            gameOutput.setText(valid);
            scored ++;
            score.setText("Score: " + scored);}
        else if (pf.evaluate(expression) != 24){
            gameOutput.setText(invalid);}
        
            FileWriter file = new FileWriter("gamelogs.txt", true);
            BufferedWriter write = new BufferedWriter(file);
            PrintWriter pWrite = new PrintWriter(write);

            tries++;
            pWrite.println("Card-24 Game Computer Validation Test: " + tries + "----");
            pWrite.println("User typed: " + expression);
            if (pf.evaluate(expression) == 24) {
                pWrite.println("Computing expression.......   " + valid);
                pWrite.println("This set took you " + minutes +" minutes and "+ seconds + " seconds.");
                pWrite.println("Score is: " + scored);
            } else if (pf.evaluate(expression) != 24) {
                pWrite.println("Computing expression.....   " + invalid);
                pWrite.println("Score remains: " + scored);
            } else {
                pWrite.println("Computer can't compute...empty expression");
            }
            pWrite.println("");
            pWrite.close();
            write.close();
            file.close();

        } catch (IOException io) {
        } catch (EmptyStackException e){
            gameOutput.setText("Empty: Not Valid");
        }
        timeline.stop();
    }
      @FXML
    void solution(ActionEvent event) {
        timeline.stop();
        gameOutput.setText("You Give Up");
        userInput.setText("");
    }
}