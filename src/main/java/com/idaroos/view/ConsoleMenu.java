package com.idaroos.view;

import com.idaroos.model.Clock;

import java.util.Scanner;

public class ConsoleMenu {
    private  Clock clock = new Clock();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        String userInput = "";

        while (!userInput.equals("5")) {
        System.out.println("Current state -" + clock.getCurrentState());
        System.out.println("Enter one of the alternatives: ");
        System.out.println("1. Display Time");
        System.out.println("2. Display Date");
        System.out.println("3. Change Time");
        System.out.println("4. Change Date");
        System.out.println("5. Quit application");

        userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                if(clock.getCurrentState() == Clock.STATE.DisplayDate){
                    clock.changeMode();
                }  else{
                    System.out.println("Invalid choice");
                }
                break;
            case "2":
                if(clock.getCurrentState() == Clock.STATE.DisplayTime){
                    clock.changeMode();
                } else{

                    System.out.println("Invalid choice");
                }
                break;
            case "3":
                if(clock.getCurrentState() == Clock.STATE.DisplayTime) {
                    clock.readyToSet();
                    System.out.println("Enter new time");
                    userInput = scanner.nextLine();
                    clock.changeTime(userInput);
                    clock.set();
                } else {
                    System.out.println("Invalid choice.");
                }
                break;
            case "4":
                if(clock.getCurrentState() == Clock.STATE.DisplayDate) {
                    clock.readyToSet();
                    System.out.println("Enter new date");
                    userInput = scanner.nextLine();
                    clock.changeDate(userInput);
                    clock.set();
                } else{
                    System.out.println("Invalid choice");
                }
                break;

            case "5":
                System.out.println("Exiting application.");
break;
            default:
                System.out.println("Invalid choice");
        }
    }
}


}
