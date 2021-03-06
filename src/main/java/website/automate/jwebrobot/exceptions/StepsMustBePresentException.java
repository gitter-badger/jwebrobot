package website.automate.jwebrobot.exceptions;

public class StepsMustBePresentException extends RuntimeException {

    private static final long serialVersionUID = -8471151278952806816L;

    private static final String MESSAGE = "Steps must be provided in scenario %s.";

    public StepsMustBePresentException(String scenarioName) {
        super(String.format(MESSAGE, scenarioName));
    }
}
