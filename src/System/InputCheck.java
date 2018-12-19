package System;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class InputCheck {
    public static boolean datecheck(String date) {
        String s = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean pwdcheck(String pwd) {
        if (pwd.length() != 6) return false;
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (!pattern.matcher(pwd).matches()) return false;
        return true;
    }
}
