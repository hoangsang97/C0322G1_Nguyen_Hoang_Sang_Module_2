package ss18_string_regex.exercise.validate_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public ValidatePhone() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
