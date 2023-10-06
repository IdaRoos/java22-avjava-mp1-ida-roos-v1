package org.example.model;

import org.example.interfaces.ChangeMode;

import java.time.LocalDate;
import java.time.LocalTime;

public class Clock implements ChangeMode {

    private STATE currentState = STATE.DisplayTime;
    private Time time = new Time();
    private Date date = new Date();

    public enum STATE {
        DisplayTime,
        DisplayDate,
        ChangeTime,
        ChangeDate,
    }

    // Kolla så att state är korrekt när en användare vill ändra tid eller datum
    @Override
    public void readyToSet() {
        if (currentState == STATE.DisplayTime) {
            currentState = STATE.ChangeTime;
        } else if (currentState == STATE.DisplayDate) {
            currentState = STATE.ChangeDate;
        } else {
            System.out.println("Invalid choice");
        }
    }

    // Visa tid eller datum beroende på state
    @Override
    public void set() {
        if (currentState == STATE.ChangeTime) {
            currentState = STATE.DisplayTime;
        } else if (currentState == STATE.ChangeDate) {
            currentState = STATE.DisplayDate;
        } else {
            System.out.println("Invalid choice");
        }
    }

    // Ändra mellan visning av tid och visning av datum
    @Override
    public void changeMode() {
        if (currentState == STATE.DisplayTime) {
            currentState = STATE.DisplayDate;
        } else if (currentState == STATE.DisplayDate) {
            currentState = STATE.DisplayTime;
        } else {
            System.out.println("Invalid choice");
        }
    }

    // Hämta aktuell tid
    public LocalTime getTime() {
        return time.getLocalTime();
    }

    // Sätt ny tid
    public void setTime(String timeInput) {
        try {
            time.setLocalTime(LocalTime.parse(timeInput));
        } catch (Exception e) {
            System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
        }
    }

    // Hämta aktuellt datum
    public LocalDate getDate() {
        return date.getLocalDate();
    }

    // Sätt nytt datum
    public void setDate(String dateInput) {
        try {
            date.setLocalDate(LocalDate.parse(dateInput));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        }
    }

    // Hämta aktuellt tillstånd
    public STATE getCurrentState() {
        return currentState;
    }
}
