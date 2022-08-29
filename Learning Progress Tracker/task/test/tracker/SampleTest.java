package tracker;

import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    public void test() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.add("John Doe johnd@email.net");
        classRoom.add("Jane Spark jspark@yahoo.com");
        System.out.println(classRoom.students.get(10000));
        classRoom.addPoints("10000 600 400 0 0");
        NotifyService notifyService = new NotifyService(classRoom);
        notifyService.processStudentsToNotify();
        notifyService.processStudentsToNotify();
    }
}
