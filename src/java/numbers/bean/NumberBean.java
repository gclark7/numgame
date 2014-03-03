/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbers.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import model.GuessNumber;

/**
 *
 * @author gcDataTechnology
 */
@Named("numberBean")
@SessionScoped
public class NumberBean implements Serializable{
    private static final long serialVersionUID = 1;
    private int userGuess;
    private int defaultGuess;
    private boolean gameOn;
    private String guessMessage;
    private String betweenMessage;
    private boolean resetVisible=true;
    private boolean guessVisible=false;
    
    @Inject
    private GuessNumber game;
    
    /**
     * Creates a new instance of NumberBean
     */
    public NumberBean() {
        
    }
    
    @PostConstruct
    public void init() {
        defaultGuess=2;
        userGuess=defaultGuess;
        betweenMessage = "Enter a number between " + game.getLowNumber() + " And " + game.getHighNumber();
    }
    
    /**
     * Starts the game with an initial guess and enters subsequent guesses
     * @return Message related to guess and magicNumber value
     */
    public String guess(){
        if(!gameOn){
            game.startGame();
            setResetVisible(false);
            setGuessVisible(true);
        }
        
        makeAGuess();
        return "index";
    }
    
    public int getUserGuess(){
        return userGuess;
    }
    
    public void setUserGuess(int userGuess){
       this.userGuess=userGuess;
    }
    
    private void makeAGuess(){
        String msgGuess = game.guess(userGuess);
        this.gameOn=game.getGameOn();
            if(!gameOn){
                //set some values to reset the game
                setResetVisible(true);
                setGuessVisible(false);
            }
        setGuessMessage(msgGuess);
    }
    
    public void setGuessMessage(String s){
        guessMessage=s;
    }
    
    public String getGuessMessage(){
        return guessMessage;
    }
    
    public String getBetweenMessage(){
        return betweenMessage;
    }
    
    public void setBetweenMessage(String s){
        betweenMessage = s;
    }

    public int getDefaultGuess() {
        return defaultGuess;
    }

    public void setDefaultGuess(int defaultGuess) {
        this.defaultGuess = defaultGuess;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public GuessNumber getGame() {
        return game;
    }

    public void setGame(GuessNumber game) {
        this.game = game;
    }
    
    public void setResetVisible(boolean visible){
        this.resetVisible=visible;
    }
    public boolean getResetVisible(){
        return resetVisible;
    }
    public void setGuessVisible(boolean visible){
        this.guessVisible=visible;
    }
    
    public boolean getGuessVisible(){
        return guessVisible;
    }
}
