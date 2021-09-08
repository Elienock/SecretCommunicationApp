package za.ac.tut.messageexception;

public class MessageException extends Exception {
    public MessageException(String errorMsg){
        super(errorMsg);
    }
}
