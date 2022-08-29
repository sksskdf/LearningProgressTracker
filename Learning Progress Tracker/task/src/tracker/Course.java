package tracker;

import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Course {
    String name;
    int numberOfPoints;

    int activity, score;
    Set<Integer> students;

    public Course(String name, int numberOfPoints) {
        this.name = name;
        this.numberOfPoints = numberOfPoints;
        students = new HashSet<>();
        activity = 0;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getPopular() {
        return students.size();
    }

    public int getActivity() {
        return activity;
    }

    public double getScore() {
        return (double)score / (double)activity;
    }

    public void setPopular(int studentId) {
        students.add(studentId);
    }

    public void incActivity() {
        activity++;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void addScore(int idStudent, int score) {
        if (score > 0) {
            setPopular(idStudent);
            incActivity();
            setScore(score);
        }
    }

    public void getStat(int courseID, Map<Integer, Student> studentsCourse) {
        System.out.println(getName());
        System.out.println("id     points completed");
        NavigableMap<Integer, Student> orderMap = new TreeMap<>();
        for (int studentId: students) {
            Student student = studentsCourse.get(studentId);
            int points = student.getPoints()[courseID];
            orderMap.put(points - studentId, student);
        }
        for (var entry: orderMap.descendingMap().entrySet()) {
            Student student = entry.getValue();
            int points = student.getPoints()[courseID];
            System.out.printf("%d\t%d\t\t %.1f%%\n", student.getId(), points, (double)points / (double)numberOfPoints * 100);
        }
    }
}
