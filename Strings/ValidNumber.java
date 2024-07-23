package Strings;

import java.util.regex.Pattern;

public class ValidNumber {
    public boolean isNumber(String s) {
        return Pattern.matches("^[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?", s);
    }
}
