package za.ac.tut.messagemanager;

import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;
import za.ac.tut.messagemanagerdata.MessageManagerData;
import za.ac.tut.messagemanagerinterface.MessageManagerInterface;

import java.io.*;

public class MessageManager implements MessageManagerInterface, MessageManagerData {
    private boolean isUpperCaseLetter(int asciiValue) {
        //Based on the ascii table for upper case letter in the alphabet
        return (asciiValue <= 90 && asciiValue >= 65);
    }

    @Override
    public Message executeFSE(Message message) throws MessageException {
        // First make all characters upper case so that we can use the upper case letter ascii codes to compare
        String msg = message.getMessage().toUpperCase();

        // An alternative to using StringBuilder is to use a String encodedMessage = "";
        StringBuilder encodedMessage = new StringBuilder();

        // Every String can be considered as an array of characters that's why message.length()
        for (int i = 0; i < msg.length(); ++i) {

            // getting charAt from a string when assigned to a int give us the ascii code
            int asciiValue = msg.charAt(i);

            // if the character is not an upper case letter from the alphabet then go to else
            if (isUpperCaseLetter(asciiValue)) {

                // if adding will go beyond the 26th letter of the alphabet roll over
                if (asciiValue + 3 <= 90) {
                    encodedMessage.append((char) (asciiValue + 3));
                } else {

                    // get the remainder from the division to roll over
                    int k = (asciiValue + 3) % 90;

                    //If String encodedMessage = "" was used just do  encodedMessage+=(char) (64 + k)
                    encodedMessage.append((char) (64 + k));
                }
            } else {

                // If String encodedMessage = "" was used just do  encodedMessage+=(char) asciiValue;
                encodedMessage.append((char) (asciiValue));
            }

        }
        //return an instance of message
        return new Message(encodedMessage.toString());
    }

    @Override
    public Message executeBSE(Message message) throws MessageException {
        String msg = message.getMessage().toUpperCase();
        StringBuilder decodedMessage = new StringBuilder();

        //same as the technique above in fact one way to modify the code is to put this entire for loop in a function
        for (int i = 0; i< msg.length(); ++i) {
            int asciiValue = msg.charAt(i);
            if (isUpperCaseLetter(asciiValue)) {
                // If  subtracting will go below our alphabet upper case letters ascii
                if (asciiValue - 3 >= 65) {
                    decodedMessage.append((char) (asciiValue - 3));
                } else {
                    int k = asciiValue - 3;
                    decodedMessage.append((char) (64 + k));
                }
            } else {
                decodedMessage.append((char) (asciiValue));
            }
        }
        //create an instance for message and return
        return new Message(decodedMessage.toString());
    }

    @Override
    public void storeMessageInFile(File file, Message message) throws IOException {
        //instances
        BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));

        //write to file
        bw.write(message.toString());

        //End of the line and start a new one
        bw.newLine();

        //close file
        bw.close();
    }

    @Override
    public void scrambleMessageTechnique(Message message,int choice,File file) throws IOException, MessageException {
        Message msg;

        //Depending on the user choice, if the user wants to scramble the message using BSE
        if(choice==BSE){
            //It will execute BSE, because that is scramble technique user chose
            msg=executeBSE(message);
        }else{
            //it executes FSE
            msg=executeFSE(message);
        }
        //stores it in the scramble message file
        storeMessageInFile(file,msg);
    }

    @Override
    public Message readTheMessageFromFile(File file) throws IOException, MessageException {
        String data, records = "";
        //open the reading stream
        BufferedReader br = new BufferedReader(new FileReader(file));

        //read data from the file
        data = br.readLine();

        //read whilst there's still data
        while(data != null){
            //concatenate the records
            records += data + "\n";

            //read again
            data = br.readLine();
        }

        //close the reading stream
        br.close();


        //return an instance of message
        return new Message(records);
    }

    @Override
    public void unScrambleMessageTechnique(File file,File fname ,int choice) throws IOException, MessageException {
       //Declare Variables
        Message msg;
        Message message=readTheMessageFromFile(fname);

       // If a message scrambled using FSE, the user has to use BSE to unscramble the message
        if(choice==BSE){
            //Execute BSE depending on the scramble technique used
            msg=executeBSE(message);
        }else{
            //Execute FSE depending on the scrambled technique used
            msg=executeFSE(message);
        }
        //The readable form must be stored in a separate file called the unscrambled message
        storeMessageInFile(file,msg);
    }
}
