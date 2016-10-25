package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

/**
 * Created by cftahadlangit on 10/25/2016.
 */

public class RockPaperScissorsLizardSpock extends Frame {
    private Label lblYourChoice;
    private CheckboxGroup options = new CheckboxGroup();
    private TextArea resultDesc;
    private TextField playerScore;
    private TextField computerScore;
    private Button launch;
    private Checkbox rock = new Checkbox("ROCK", options, false);
    private Checkbox paper = new Checkbox("PAPER", options, false);
    private Checkbox scissors = new Checkbox("SCISSORS", options, false);
    private Checkbox lizard = new Checkbox("LIZARD", options, false);
    private Checkbox spock = new Checkbox("SPOCK", options, false);
    private int result;
    private Dialog dialog;
    private Label dLabel;
    private Button dButton;
    int pScore;
    int cScore;

    public RockPaperScissorsLizardSpock() {
        //layout
        setLayout(new FlowLayout());

        lblYourChoice = new Label("Your Choice:"); 
        resultDesc = new TextArea("Result: ");
        resultDesc.setEditable(false);
        Label ps = new Label("Player's Score");
        Label cs = new Label("Computer's Score");
        playerScore = new TextField();
        playerScore.setEditable(false);
        computerScore = new TextField();
        computerScore.setEditable(false);
        launch = new Button("RockPaperScissorsLizardSpock!");

        dialog = new Dialog(this,"Game Over!",Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setLayout(new FlowLayout());
        dLabel = new Label("");
        dButton = new Button("Replay");
        dButton.setSize(100,200);
        dialog.setSize(250,100);
        dialog.add(dLabel);
        dialog.add(dButton);

        //reset the game
        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pScore = 0;
                cScore = 0;
                resultDesc.setText("");
                playerScore.setText("");
                computerScore.setText("");
                dialog.dispose();
            }
        });

        //close dialog frame
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent we){
                System.exit(0);
            }
        });

        //anonymous class
        launch.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkbox();
                if(pScore == 5 || cScore == 5) {
                    gameOver();
                }
            }
        }));

        //add them to the container
        add(lblYourChoice);
        add(rock);
        add(paper);
        add(scissors);
        add(lizard);
        add(spock);
        add(resultDesc);
        add(launch);
        add(ps);
        add(playerScore);
        add(cs);
        add(computerScore);
        setTitle("RockPaperScissorsLizardSpock");
        setSize(500,280);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent we){
                System.exit(0);
            }
        });
    }

    public void checkbox() {
        String[] op = new String[]{"ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK"}; //String array of all the possible options
        Random rand = new Random(); //instantiate rand
        String random = op[rand.nextInt(op.length)]; //randomly select from the string array
        // 1 if winner , 0 if draw, -1 if loser
        if(options.getSelectedCheckbox() == rock){
            if(random == "SCISSORS" || random == "LIZARD"){
                result = 1;
            }else if(random == "ROCK"){
                result = 0;
            }else{
                result = -1;
            }
        }else if(options.getSelectedCheckbox() == paper){
            if(random == "ROCK" || random == "SPOCK"){
                result = 1;
            }else if(random == "PAPER"){
                result = 0;
            }else{
                result = -1;
            }
        }else if(options.getSelectedCheckbox() == scissors){
            if(random == "PAPER" || random == "LIZARD"){
                result = 1;
            }else if(random == "SCISSORS"){
                result = 0;
            }else{
                result = -1;
            }
        }else if(options.getSelectedCheckbox() == lizard){
            if(random == "PAPER" || random == "SPOCK"){
                result = 1;
            }else if(random == "LIZARD"){
                result = 0;
            }else{
                result = -1;
            }
        }else if(options.getSelectedCheckbox() == spock){
            if(random == "ROCK" || random == "SCISSOR"){
                result = 1;
            }else if(random == "SPOCK"){
                result = 0;
            }else{
                result = -1;
            }
        }
        //if the player wins, his score will increase  while nothing happens to the score of the computer
        if (result == 1) {
            pScore++;
            resultDesc.setText("Result:" + "\n");
            resultDesc.append("Player chose " + options.getSelectedCheckbox().getLabel() + "\n");
            resultDesc.append("Computer chose " + random + "\n\n" );
            resultDesc.append("YOU WON THIS ROUND.");
            playerScore.setText(pScore + "");
        }
        //if the player loses, the computer gets the score 
        if (result == -1) {
            cScore++;
            resultDesc.setText("Result:" + "\n");
            resultDesc.append("Player chose " + options.getSelectedCheckbox().getLabel() + "\n");
            resultDesc.append("Computer chose " + random  + "\n\n");
            resultDesc.append("COMPUTER WON THIS ROUND.");
            computerScore.setText(cScore + "");
        }
        //if the player and the computer selected the same option neither of their scores will increase
        if (result == 0) {
            resultDesc.setText("Result:" + "\n");
            resultDesc.append("Player chose " + options.getSelectedCheckbox().getLabel() + "\n");
            resultDesc.append("Computer chose " + random  + "\n\n");
            resultDesc.append("IT'S A DRAW!");
        }
    }

    public void gameOver(){
        if(pScore == 5 && cScore < 5){ //checks if either of the player and computer reached 5 pts
            dLabel.setText("Congratulations Player won!");
        }else{
            dLabel.setText("Computer won!");
        }
        dialog.setVisible(true);
    }

    public static void main(String args[]){
       new RockPaperScissorsLizardSpock();
    }
}
