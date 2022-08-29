package tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifyService {
    private ClassRoom classRoom;
    private int total = 0;



    public NotifyService(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public void processStudentsToNotify() {
        total = 0;

        Map<Integer, Student> students = classRoom.students;
        Map<Integer, Course> courses = classRoom.courses;

        for (var s : students.entrySet()) {
            int[] points = s.getValue().getPoints();
            List<String> courseName = new ArrayList<>();

            if (!s.getValue().isHasNotified()) {
                for (int i = 0; i < points.length; i++) {
                    if (points[i] >= courses.get(i).numberOfPoints) {
                        courseName.add(courses.get(i).name);
                    }
                }

                for (String cn : courseName) {
                    Notify notify = new Notify(s.getValue().getEmail(), s.getValue().getFullName(), cn);
                    notify.printNotify();
                    s.getValue().setHasNotified(true);
                }

                if (s.getValue().isHasNotified()) {
                    total++;
                }
            }
        }

        System.out.printf("Total %d students have been notified.%n", total);
    }


}
