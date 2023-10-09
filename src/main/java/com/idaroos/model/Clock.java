package com.idaroos.model;

import com.idaroos.interfaces.ChangeModeInterface;
import com.idaroos.interfaces.ClockInfoInterface;

import java.time.LocalDate;
import java.time.LocalTime;

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
        if(currentState == STATE.ChangeTime){
            try {
                time.setLocalTime(LocalTime.parse(input));
            } catch (Exception e) {
                System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
            }
        }else if(currentState == STATE.DisplayTime){
            readyToSet();

        }else {
            System.out.println("Invalid choice");
        }
    }

    @Override
    public void changeDate(String input) {
        if(currentState == STATE.ChangeDate){
            try {
                date.setLocalDate(LocalDate.parse(input));
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }
        } else if(currentState == STATE.DisplayDate){
            readyToSet();
        } else {
            System.out.println("Invalid choice");
        }
    }

    @Override
    public void displayTime() {
        if(currentState == STATE.DisplayTime){
            System.out.println(time.getLocalTime()); }
        else if(currentState == STATE.DisplayDate){
            changeMode();
        }else if(currentState == STATE.ChangeTime){
            set();
        }
        else{
            System.out.println("Invalid choice. Current state - " + currentState);
        }
    }

    @Override
    public void displayDate() {

        if(currentState == STATE.DisplayDate){
            System.out.println(date.getLocalDate());
        }else if(currentState == STATE.DisplayTime) {
            changeMode();
        }else if(currentState == STATE.ChangeDate){
            set();
        }
        else{
            System.out.println("Invalid choice. Current state - " + currentState);
        }
    }

    // Kolla så att state är korrekt när en användare vill ändra tid eller datum
    @Override
    public void changeMode() {
        if(currentState == STATE.DisplayTime){
            currentState = STATE.DisplayDate;
        }else if(currentState == STATE.DisplayDate) {
            currentState = STATE.DisplayTime;
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
        } else if (currentState == STATE.ChangeDate) {
            currentState = STATE.DisplayDate;
        } else {
            System.out.println("Invalid choice. Current state - " + currentState);
        }

    }

    // Hämta aktuellt tillstånd
    public STATE getCurrentState() {
        return currentState;
    }
}
