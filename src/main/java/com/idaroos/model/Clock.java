package com.idaroos.model;

import com.idaroos.interfaces.ChangeModeInterface;
import com.idaroos.interfaces.ClockInfoInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock implements ChangeModeInterface, ClockInfoInterface {

    private STATE currentState = STATE.DisplayTime;
    private Time time = new Time();
    private Date date = new Date();

    public enum STATE {
        DisplayTime,
        DisplayDate,
        ChangeTime,
        ChangeDate,
    }



    @Override
    public void changeTime(String input) {
        LocalTime newTime = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm:ss"));
        time.setLocalTime(newTime);
    }

    @Override
    public void changeDate(String input) {
                date.setLocalDate(LocalDate.parse(input));
    }

    @Override
    public void displayTime() {
        System.out.println(time.getLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

    }

    @Override
    public void displayDate() {
            System.out.println(date.getLocalDate());
    }

    // Kolla så att state är korrekt när en användare vill ändra tid eller datum
    @Override
    public void changeMode() {
        if(currentState == STATE.DisplayTime){
            currentState = STATE.DisplayDate;
            displayDate();
        }else if(currentState == STATE.DisplayDate) {
            currentState = STATE.DisplayTime;
            displayTime();
        }else{
            System.out.println("Invalid choice. Current state - " + currentState);
        }

    }

    @Override
    public void readyToSet() {
        if (currentState == STATE.DisplayTime) {
            currentState = STATE.ChangeTime;
        } else if (currentState == STATE.DisplayDate) {
            currentState = STATE.ChangeDate;
        } else {
            System.out.println("Invalid choice. Current state - " + currentState);
        }

    }

    @Override
    public void set() {
        if (currentState == STATE.ChangeTime) {
            currentState = STATE.DisplayTime;
            displayTime();
        } else if (currentState == STATE.ChangeDate) {
            currentState = STATE.DisplayDate;
            displayDate();
        } else {
            System.out.println("Invalid choice. Current state - " + currentState);
        }

    }

    // Hämta aktuellt tillstånd
    public STATE getCurrentState() {
        return currentState;
    }
}
