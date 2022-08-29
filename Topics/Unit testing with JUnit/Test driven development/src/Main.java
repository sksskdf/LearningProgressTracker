import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Objects.isNull;

class Person {
    // Do not change these fields
    public static final String DEFAULT_NAME = "Unknown";
    public static final int MAX_AGE = 130;
    public static final int MIN_AGE = 0;
    private String name;
    private int age;

    // Fix the constructor to make its code pass the unit tests
    public Person(String name, int age) {
        this.name = isNull(name) || name.isBlank() ? DEFAULT_NAME : name;
        this.age = min(MAX_AGE, max(MIN_AGE, age));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}