package com.company;

import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;
import za.ac.tut.messagemanager.MessageManager;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Declare Variables
        MessageManager ms = new MessageManager();
        File fname = new File("./scrambleMessage.txt");
        File file = new File("./unScrambledMessage.txt");
        int userChoice, userChoice1 = 0;

        userChoice = displayMenu();
        while (userChoice != 3) {
            switch (userChoice) {
                case 1:
                    try {
                        String shortMessage = JOptionPane.showInputDialog(null, "Please enter your  message: ", "Readable message",
                                JOptionPane.PLAIN_MESSAGE);
                        //create an instance of message
                        Message message = new Message(shortMessage);
                        //ask which technique they want to use to scrambled message
                        userChoice1 = scramblingTechniqueMenu();

                        //if user chooses 1, he has to scramble the message using BSE
                        if (userChoice1 == 1) {
                            ms.scrambleMessageTechnique(message, 1, fname);

                        } else {
                            //else use the FSE
                            ms.scrambleMessageTechnique(message, 0, fname);
                        }
                        //Catch the exception
                    } catch (IOException | MessageException ne) {
                        JOptionPane.showMessageDialog(null, ne.getMessage());
                    }
                    break;
                    //read the exception
                case 2:
                    try {
                        if (userChoice1 == 1) {
                            JOptionPane.showMessageDialog(null, "Your friend used the Backward Substitution Technique  " + "\n" +
                                    "to make it readable you have to use the Forward Substitution Technique", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                            //Ask the user to unscramble the message
                            userChoice1 = scramblingTechniqueMenu();
                            //if he chooses 1 , it unscrambles the message using the BSE
                            if (userChoice1 == 1) {
                                //invoke the methos
                                ms.unScrambleMessageTechnique(file, fname, 1);
                                //read the message method
                                Message readableMessage = ms.readTheMessageFromFile(file);
                                //Display the message
                                JOptionPane.showMessageDialog(null,"The secret message is " + "\n" +
                                readableMessage);
                            } else {
                                //Invoke the unscramble the method
                                ms.unScrambleMessageTechnique(file, fname, 0);
                                //read the message method
                                Message readableMessage = ms.readTheMessageFromFile(file);
                                //Display the message
                                JOptionPane.showMessageDialog(null,"The secret message is " + "\n" +
                                        readableMessage);
                            }
                        } else {
                            //Tells the user which method was used to scramble the message
                            JOptionPane.showMessageDialog(null, "Your friend used the Forward Substitution Technique  " + "\n" +
                                    "to make it readable you have to use the Backward Substitution Technique", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                            //menu to unscramble the message
                            userChoice1 = scramblingTechniqueMenu();
                            //user choice
                            if (userChoice1 == 1) {
                                //unscramble the message depending on the user choice
                                ms.unScrambleMessageTechnique(file, fname, 1);
                            } else {
                                //unscramble the message depending on the user choice
                                ms.unScrambleMessageTechnique(file, fname, 0);
                            }
                        }
                        //catch the exception
                    } catch (IOException | MessageException ne) {
                        JOptionPane.showMessageDialog(null, ne.getMessage());
                    }
                    break;
                default:

            }
            //display menu again
            userChoice = displayMenu();

        }
        //display end message
        JOptionPane.showMessageDialog(null, "GoodBye!!!",
                "End", JOptionPane.INFORMATION_MESSAGE);
    }

        public static int displayMenu () {
            //declare variables
            int option = 0;
            String strOption;
            boolean reDo=true;

            do{
                try{
            //display menu options
            strOption = JOptionPane.showInputDialog(null, """
                            Please select one of the following options
                            -----------------------------------------------------------
                            1 - Enter scrambled message\s
                            2 - Unscramble and Read the secret message
                            3 - Exit""",
                    "Menu options", JOptionPane.INFORMATION_MESSAGE);

            //convert the option to an integer
            option = Integer.parseInt(strOption);

                    if(option>0 && option<4) {
                        reDo = false;
                    }else{
                        JOptionPane.showMessageDialog(null, option + " is invalid. Please enter either 1, 2 or 3.",
                                "Invalid choice", JOptionPane.ERROR_MESSAGE);
                    }
                    }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,nfe.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }while (reDo);

            //return option
            return option;
        }


        public static int scramblingTechniqueMenu () {
            //declare variables
            int option=0;
            String strOption;
            boolean reDo=true;

            do{
                try{
            //display menu options
            strOption = JOptionPane.showInputDialog(null, """
                            Which Encryption Technique did you see
                            -----------------------------------------------------------
                            1 - Backrward Substitution Encryption(BSE)\s
                            2 - Forward Substitution Encryption(FSE)""",
                    "Menu options", JOptionPane.INFORMATION_MESSAGE);

            //convert the option to an integer
            option = Integer.parseInt(strOption);
                    option = Integer.parseInt(strOption);
                    if(option>0 && option<3) {
                        reDo = false;
                    }else{
                        JOptionPane.showMessageDialog(null,"Wrong input.Enter a correct number from 1 to 3","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,nfe.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }while (reDo);

            //return option
            return option;

        }

    }
