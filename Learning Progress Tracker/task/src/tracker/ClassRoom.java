package tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ClassRoom {
    final static String JAVA = "Java";
    final static String DSA = "DSA";
    final static String DB = "Databases";
    final static String SPRING = "Spring";
    Map<Integer, Student> students;
    int currId;
    Map<String, Integer> courseOrder;
    Map<Integer, Course> courses;

    public ClassRoom() {
        students = new HashMap<>();
        courses = new HashMap<>();
        courseOrder = new HashMap<>();
        initCourses();
        currId = 10000;
    }

    private void initCourses() {
        int order = 0;
        addCourse(order++, JAVA, 600);
        addCourse(order++, DSA, 400);
        addCourse(order++, DB, 480);
        addCourse(order, SPRING, 550);
    }

    public void addCourse(int order, String name, int numberOfPoints) {
        courseOrder.put(name.toLowerCase(), order);
        Course course = new Course(name, numberOfPoints);
        courses.put(order, course);
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    private void nextId() {
        currId++;
    }

    public static boolean testPoints(String input) {
        Pattern pattern = Pattern.compile("\\d+ \\d+ \\d+ \\d+ \\d+");
        return pattern.matcher(input).matches();
    }

    public boolean add(String studentLine) {
        Student student = new Student(currId);
        var array = studentLine.split(" ");
        if (array.length < 3) {
            System.out.println("Incorrect credentials");
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < array.length - 1; i++) {
            if (i > 1) stringBuilder.append(" ");
            stringBuilder.append(array[i]);
        }
        if (!student.setFirstName(array[0])) {
            System.out.println("Incorrect first name.");
            return false;
        }
        if (!student.setLastName(stringBuilder.toString())) {
            System.out.println("Incorrect last name.");
            return false;
        }

        var email = array[array.length - 1];
        if (!testEmail(email)) {
            System.out.println("This email is already taken");
            return false;
        } else if (!student.setEmail(email)) {
            System.out.println("Incorrect email.");
            return false;
        }

        students.put(currId, student);
        nextId();
        System.out.println("The student has been added.");
        return true;
    }

    public void addPoints(String input) {
        var err = "No student is found for id=%s\n";
        String[] data = input.split(" ");

        int id;
        Student student;
        try {
            id = Integer.parseInt(data[0]);
            student = students.get(id);
        } catch (Exception e) {
            System.out.printf(err, data[0]);
            return;
        }

        if (!testPoints(input)) {
            System.out.println("Incorrect points format.");
            return;
        }

        int[] arrPoints = new int[4];
        for (int i = 1; i < data.length; i++) {
            arrPoints[i - 1] = Integer.parseInt(data[i]);
            Course course = courses.get(i - 1);
            course.addScore(id, arrPoints[i - 1]);
        }
        student.setPoints(arrPoints);
        System.out.println("Points updated.");
    }

    private boolean testEmail(String email) {
        for (var st : students.entrySet()) {
            if (email.equals(st.getValue().getEmail()))
                return false;
        }
        return true;
    }

    public void find(String idStudent) {
        int id = Integer.parseInt(idStudent);
        if (students.containsKey(id))
            System.out.println(students.get(id).toString());
        else {
            System.out.printf("No student is found for id=%d\n", id);
        }
    }

    public void getStats() {
        int maxPop = 0;
        int minPop = Integer.MAX_VALUE;
        String maxPopular = "n/a";
        String minPopular = "n/a";
        int maxAct = 0;
        int minAct = Integer.MAX_VALUE;
        String maxActivity = "n/a";
        String minActivity = "n/a";
        double maxScore = 0;
        double minScore = Double.MAX_VALUE;
        String easiest = "n/a";
        String hardest = "n/a";

        if (students.size() > 0) {
            for (var cr : courses.entrySet()) {
                Course course = cr.getValue();

                int currPop = course.getPopular();
                if (currPop > maxPop) {
                    maxPop = currPop;
                    maxPopular = course.getName();
                } else if (currPop == maxPop) {
                    maxPopular = maxPopular + ", " + course.getName();
                } else if (currPop < minPop) {
                    minPop = currPop;
                    minPopular = course.getName();
                } else if (currPop == minPop) {
                    minPopular = minPopular + ", " + course.getName();
                }

                int currAct = course.getActivity();
                if (currAct > maxAct) {
                    maxAct = currAct;
                    maxActivity = course.getName();
                } else if (currAct == maxAct) {
                    maxActivity = maxActivity + ", " + course.getName();
                } else if (currAct < minAct) {
                    minAct = currAct;
                    minActivity = course.getName();
                } else if (currAct == minAct) {
                    minActivity = minActivity + ", " + course.getName();
                }

                double currScore = course.getScore();
                if (currScore > maxScore) {
                    maxScore = currScore;
                    easiest = course.getName();
                } else if (currScore == maxScore) {
                    easiest = easiest + ", " + course.getName();
                } else if (currScore < minScore) {
                    minScore = currScore;
                    hardest = course.getName();
                } else if (currScore == minScore) {
                    hardest = hardest + ", " + course.getName();
                }
            }
        }
        System.out.printf("Most popular: %s\n", maxPopular);
        System.out.printf("Least popular: %s\n", minPopular);
        System.out.printf("Highest activity: %s\n", maxActivity);
        System.out.printf("Lowest activity: %s\n", minActivity);
        System.out.printf("Easiest course: %s\n", easiest);
        System.out.printf("Hardest course: %s\n", hardest);
    }

    public void getStat(String courseName) {
        int courseID;
        try {
            courseID = courseOrder.get(courseName.toLowerCase());
        } catch (Exception e) {
            System.out.println("Unknown course.");
            return;
        }
        Course course = courses.get(courseID);
        course.getStat(courseID, students);
    }
}
