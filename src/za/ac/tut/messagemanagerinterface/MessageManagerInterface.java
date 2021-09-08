package za.ac.tut.messagemanagerinterface;

import za.ac.tut.message.Message;
import za.ac.tut.messageexception.MessageException;

import java.io.File;
import java.io.IOException;

public interface MessageManagerInterface {
    public Message executeFSE(Message message) throws MessageException;
    public Message executeBSE(Message message) throws MessageException;
    public void storeMessageInFile(File file, Message message) throws IOException;
    public void scrambleMessageTechnique(Message message,int choice,File file) throws IOException, MessageException;
    public Message readTheMessageFromFile(File file) throws IOException, MessageException;
    public void unScrambleMessageTechnique(File file,File fname ,int choice) throws IOException, MessageException;

}
