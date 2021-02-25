package edu.wctc;

public class UnknownGenderCodeException extends Exception {
    public UnknownGenderCodeException(char genderCode) {
        super(String.format("%c is not a known gender.", genderCode));
    }
}
