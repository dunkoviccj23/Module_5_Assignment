package edu.wctc;

public class MissingNameException extends Exception {
    public MissingNameException(String nameType) {
        super(String.format("%s can not be blank.", nameType));
    }
}
