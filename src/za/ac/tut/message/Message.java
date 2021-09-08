package za.ac.tut.message;

import za.ac.tut.messageexception.MessageException;
import za.ac.tut.messageinterface.MessageInterface;

public class Message implements MessageInterface {
    private String message;

    public Message(String message) throws MessageException {
        setMessage(message);
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) throws MessageException {
        if(isMessageValid(message)) {
            this.message = message;
        }else{
            throw new MessageException(message + MESSAGE_ERROR_MESSAGE);
        }
    }

    private boolean isMessageValid(String message) {
        boolean isValid=true;
        char[] chars =message.toCharArray();

        //iterate through every char in the message
        for (char charAtIndex: chars){
            //if it finds a digit,isValid is false
            if(!Character.isLetter(charAtIndex)){
                return isValid=false;
            }
        }
        return isValid;
    }

    @Override
    public String toString() {

        return message ;
    }
}
