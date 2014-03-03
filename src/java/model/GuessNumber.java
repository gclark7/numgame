/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author gcDataTechnology
 */
public class GuessNumber implements Serializable{
    private final String MESSAGE_ERR="No guess found";
    private final String MESSAGE_HIGH="Too high";
    private final String MESSAGE_LOW="Too low";
    private final String MESSAGE_CORRECT=" That's It";
    private int magicNumber;
    private boolean gameOn;
    private int lNum;
    private int hNum;
    private String guessMessage;
    
    /**
     * default constructor
     */
    
    public GuessNumber(){
        lNum=1;
        hNum=10;
    }
    
    public String guess(int guess){
        String msg = MESSAGE_ERR;
        if(guess==magicNumber){
            msg=MESSAGE_CORRECT;
            gameOn=false;
        }else if(guess>magicNumber){
            msg=MESSAGE_HIGH;
            gameOn=true;
        }else if(guess<magicNumber){
            msg=MESSAGE_LOW;
            gameOn=true;
        }
        setGuessMessage(msg);
        return msg;
    }
    
    public void startGame(){
        magicNumber= lNum + (int)(Math.random() * ((hNum - lNum) + 1));
        gameOn=true;
    }
    
    public void quit(){
        gameOn=false;
    }
    
    public int getMagicNumber(){
        return magicNumber;
    }
    
    public void setLowNumber(int low){
        lNum=low;
    }
    
    public void setHighNumber(int high){
        hNum=high;
    }
    
    public int getHighNumber(){
        return hNum;
    }
    
    public int getLowNumber(){
        return lNum;
    }
    
    public boolean getGameOn(){
        return gameOn;
    }
    
    public String getGuessMessage(){
        return guessMessage;
    }
    
    public void setGuessMessage(String s){
        guessMessage= s;
    }
}
