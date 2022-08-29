package tracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SampleTest {

    @ParameterizedTest
    @CsvSource({"John Doe johnd@email.net, Jane Spark jspark@yahoo.com, 10000 600 400 0 0"})
    public void test(String inputA, String inputB, String inputC) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.add(inputA);
        classRoom.add(inputB);
        System.out.println(classRoom.students.get(10000));
        classRoom.addPoints(inputC);
        NotifyService notifyService = new NotifyService(classRoom);
        notifyService.processStudentsToNotify();
        notifyService.processStudentsToNotify();
    }
}
