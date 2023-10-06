package org.example;

import org.example.model.Clock;
import org.example.view.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        ConsoleMenu consoleMenu = new ConsoleMenu(clock);

        consoleMenu.showMenu();
    }
}