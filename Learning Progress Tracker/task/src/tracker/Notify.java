package tracker;

public class Notify {
    private String email;
    private String fullName;
    private String accomplishCourse;

    private String stringFormat = "To: %s%n" +
            "Re: Your Learning Progress%n" +
            "Hello, %s! You have accomplished our %s course!%n";

    public Notify(String email, String fullName, String accomplishCourse) {
        this.email = email;
        this.fullName = fullName;
        this.accomplishCourse = accomplishCourse;
    }

    public void printNotify() {
        System.out.printf(stringFormat, email, fullName, accomplishCourse);
    }
}
