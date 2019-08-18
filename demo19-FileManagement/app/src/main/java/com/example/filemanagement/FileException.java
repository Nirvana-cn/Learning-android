package com.example.filemanagement;

import java.io.IOError;
import java.io.IOException;

/**
 * @author Alliance
 */
public class FileException extends RuntimeException {

    private MyErrorMessage myErrorMessage;
    private Exception exception = new Exception();

    public FileException(MyErrorMessage myErrorMessage) {
        super();
        this.myErrorMessage = myErrorMessage;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return myErrorMessage.toString();
    }

    public void setMessage(MyErrorMessage message) {
        this.myErrorMessage = message;
    }

    public static void handleException(MyErrorMessage myErrorMessage) throws RuntimeException {
        throw new FileException(myErrorMessage);
    }

    @Override
    public String toString() {
        return myErrorMessage.toString();
    }
}
