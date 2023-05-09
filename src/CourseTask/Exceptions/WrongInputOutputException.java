package CourseTask.Exceptions;

import java.io.IOException;

public class WrongInputOutputException extends IOException {

    public WrongInputOutputException() {
    }

    public WrongInputOutputException(String message) {
        super(message);
    }
}
