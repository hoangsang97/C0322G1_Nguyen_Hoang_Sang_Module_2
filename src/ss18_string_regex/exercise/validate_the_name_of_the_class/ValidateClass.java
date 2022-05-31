package ss18_string_regex.exercise.validate_the_name_of_the_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    /**
     * Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
     *
     * Không chứa các ký tự đặc biệt
     *
     * Theo sau ký tự bắt đầu là 4 ký tự số
     *
     * Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
     */

    private static final String CLASS_REGEX = "^[A|C|P]([0-9]{4})[GHIKLM]$";

    public ValidateClass() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
