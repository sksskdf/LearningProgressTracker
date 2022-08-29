package tracker;

public class Engine {
    final static String EXIT = "exit";
    final static String BACK = "back";
    final static String ADD = "add students";
    final static String LIST = "list";
    final static String FIND = "find";
    final static String ADD_P = "add points";
    final static String STAT = "statistics";
    final static String NOTI = "notify";

    private static ClassRoom classRoom;

    /**
     * you call constructor method at the same time engine run
     */
    public Engine() {
        classRoom = new ClassRoom();
        run();
    }

    public void run() {
        System.out.println("Learning Progress Tracker");
        while (true) {
            switch (Utils.getLine()) {
                case "" -> System.out.println("No input.");
                case EXIT -> {
                    System.out.println("Bye!");
                    return;
                }
                case BACK -> System.out.println("Enter 'exit' to exit the program.");
                case ADD -> addStudents();
                case LIST -> showStudents();
                case FIND -> findStudents();
                case ADD_P -> addPoints();
                case STAT -> getStats();
                case NOTI -> getNotify();
                default -> System.out.println("Unknown command!");
            }
        }
    }

    private void getNotify() {
        NotifyService notify = new NotifyService(classRoom);
        notify.processStudentsToNotify();
    }

    private static void getStats() {
        System.out.println("Type the name of a course to see details or 'back' to quit");
        classRoom.getStats();

        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.getStat(input);
            }
        }
    }

    private static void addStudents() {
        System.out.println("Enter student credentials or 'back' to return:");
        var count = 0;
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                System.out.printf("Total %d students have been added.\n", count);
                return;
            } else {
                if (classRoom.add(input)) count++;
            }
        }
    }

    private static void showStudents() {
        if (classRoom.getStudents().size() > 0) {
            System.out.println("Students:");
            for (var st : classRoom.getStudents().entrySet()) {
                System.out.println(st.getKey());
            }
        } else {
            System.out.println("No students found.");
        }
    }

    private static void findStudents() {
        System.out.println("Enter an id or 'back' to return:");
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.find(input);
            }
        }
    }

    private static void addPoints() {
        System.out.println("Enter an id and points or 'back' to return:");
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.addPoints(input);
            }
        }
    }
}
