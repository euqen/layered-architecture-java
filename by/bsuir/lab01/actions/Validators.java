package by.bsuir.lab01.actions;

public class Validators {

    protected Boolean isEmpty(String value) {
        if (value.length() == 0) {
            return true;
        }

        return false;
    }

    protected Boolean between(String value, int from, int to) {
        int len = value.length();

        if (len >= from && len <= to) {
            return true;
        }

        return false;
    }

    protected String Capitalize(String value) {
        String result;

        result = this.toUpperCase(value.substring(0, 1));
        result += this.toLowerCase(value.substring(1,value.length()));

        return result;
    }

    protected String toLowerCase(String value) {
        return value.toLowerCase();
    }

    protected String toUpperCase(String value) {
        return value.toUpperCase();
    }


}
