package PSS;

import java.io.IOException;

public class ScheduleController {
    //TODO: create parameters
    public static boolean createTransientTask(){
        return true;
    }
    public static boolean createRecurringTask(){
        return true;
    }
    public static boolean createAntiTask(){
        return true;
    }
    public static Tasks findTask(String name){
        Tasks exampleTask = new Tasks("task", 0f, 0f, 0);
        return exampleTask;
    }

    public static void writeSchedule(Schedule filename) throws IOException {

    }

    public static void readSchedule (Schedule filename) {

    }
}
