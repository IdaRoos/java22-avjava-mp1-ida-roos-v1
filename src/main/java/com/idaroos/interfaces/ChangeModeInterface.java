package com.idaroos.interfaces;

public interface ChangeModeInterface {

    void readyToSet(); // kollar så att state är korrekt när en användare vill ändra time eller date

    void set(); // ändra time eller date

    void changeMode(); // ändra mellan display time och display date
}
