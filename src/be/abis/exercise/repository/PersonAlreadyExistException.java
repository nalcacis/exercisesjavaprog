package be.abis.exercise.repository;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
