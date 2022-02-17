package in.parangat.a3charger.Helper;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean hasText(String s) {
        if (s.equalsIgnoreCase(""))
            return false;
        else
            return true;
    }

    public static boolean hasText(EditText s) {
        if (s.getText().toString().trim().equalsIgnoreCase(""))
            return false;
        else
            return true;
    }

    public static boolean isValidPassword(Context context, String text) {
        if (text.isEmpty()) {
            Toast.makeText(context, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(Context context, String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty()) {
            Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(email.matches(emailPattern))) {
            Toast.makeText(context, "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }  public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
