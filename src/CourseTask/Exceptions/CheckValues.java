package CourseTask.Exceptions;

public class CheckValues {

    public static String CheckString(String string) throws WrongInputOutputException {
        if (string == null || string.isBlank()) {
            throw new WrongInputOutputException("Некорректный ввод. Повторите попытку");
        } else {
            return string;
        }
    }
}
