package com.kalomiris.exception;

public class WrongNumberException extends NumberFormatException {
    private int press;

    public WrongNumberException(int press){
        this.press = press;
    }

    public String toString(){
        return "Please try again, not :" + press;
    }

}
