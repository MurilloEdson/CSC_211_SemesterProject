package com.mycompany.groupproject_csc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class PrimaryController {
    
    Timer  timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                seconds++;
                clock.setText("Time " + minutes + ":"+ seconds);
            }
        };
        
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
    private Label clock;
    int seconds = 0;
    int minutes = 0;
    boolean stop = false;

    @FXML
    private Label score;
    int scored = 0;

    @FXML
    private void refresh(ActionEvent event) throws FileNotFoundException {
        Deck deck = new Deck();

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
        //seconds = 0;
        //minutes = 0;
        //clock.setText("Time " + minutes + ":"+ seconds);
        //timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    @FXML
    void verify(ActionEvent event) {
        Verification pf =  new Verification();
        String expression = (userInput.getText());
        
        if (pf.evaluate(expression) == 24){
            gameOutput.setText("Valid Expression");
            scored ++;
            score.setText("Score: " + scored);
        }
        else if (pf.evaluate(expression) != 24){
            gameOutput.setText("Not Valid Expression");
        }
    }
      @FXML
    void solution(ActionEvent event) {

    }
     @FXML
    void timeStart(MouseEvent event) {
    }

    void timeTest(boolean bool) {
        if (bool == true){
            clock.setText("Time " + minutes + ":"+ seconds);}
        else{
            clock.setText("Time " + minutes + ":"+ seconds);
            seconds = seconds + 1/5;
            if (seconds > 60){
                seconds = seconds - 60;
                minutes = minutes + 1;}
        }
    }
}
