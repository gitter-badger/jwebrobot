package website.automate.executors.jwebrobot.exceptions;


public class UnknownCriterionException extends RuntimeException {
    private static final String MESSAGE = "Unknown criterion '%s' found.";

    public UnknownCriterionException(String criterion) {
        super(String.format(MESSAGE, criterion));
    }
}