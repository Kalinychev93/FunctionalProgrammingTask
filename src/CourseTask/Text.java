package CourseTask;

import CourseTask.Exceptions.CheckValues;
import CourseTask.Exceptions.WrongInputOutputException;

public class Text {

    String something;

    public Text(String something) throws WrongInputOutputException {
        this.something = CheckValues.CheckString(something);
    }
}
