package tracker;

import java.util.regex.Pattern;

public class Student {
    int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean hasNotified = false;

    private final int[] points;

    public Student(int id) {
        this.id = id;
        points = new int[4];
    }

    public int[] getPoints() {
        return points;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    private boolean testString(String input) {
        for (String sl: input.split(" ")) {
            if (sl.length() < 2) return false;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+([ '\\-]*[a-zA-Z]*)*");
        Pattern patternNot = Pattern.compile("(\\w*''\\w*)|(\\w*-'\\w*)|(\\w*'-\\w*)|(\\w*--\\w*)|('\\w)|(\\w+')|(-\\w)|(\\w+-)");
        return !patternNot.matcher(input).matches() && pattern.matcher(input).matches();
    }

    private boolean testEmail(String input) {
        Pattern pattern = Pattern.compile("[\\w.]+@\\w+\\.\\w+");
        return pattern.matcher(input).matches();
    }

    public boolean setFirstName(String firstName) {
        if (!testString(firstName)) return false;
        this.firstName = firstName;
        return true;
    }

    public boolean setLastName(String lastName) {
        if (!testString(lastName)) return false;
        this.lastName = lastName;
        return true;
    }

    public boolean setEmail(String email) {
        if (!testEmail(email)) return false;
        this.email = email;
        return true;
    }

    public void setPoints(int[] arrPoints) {
        for (int i = 0; i < points.length; i++) {
            points[i] += arrPoints[i];
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isHasNotified() {
        return hasNotified;
    }

    public void setHasNotified(boolean hasNotified) {
        this.hasNotified = hasNotified;
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d DSA=%d Databases=%d Spring=%d\n", id, points[0], points[1], points[2], points[3]);
    }
}
