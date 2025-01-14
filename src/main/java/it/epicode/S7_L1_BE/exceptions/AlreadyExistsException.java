package it.epicode.S7_L1_BE.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException() {
    }
    public AlreadyExistsException(String message) {
        super(message);
    }
}
