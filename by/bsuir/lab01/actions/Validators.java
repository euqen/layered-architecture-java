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


}
