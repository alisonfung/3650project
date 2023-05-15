package PSS;

import java.io.IOException;
import java.io.*;
import java.util.*;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

import static PSS.PSSInterface.schedule;

public class ScheduleController {
    //TODO: create parameters

    private static void checkForOccurrence(AntiTasks antiTask)
    {

    }
    public static boolean createTransientTask(String name, String type, Float startTime,
                                              Float duration, int startDate){
        TransientTasks newTask = new TransientTasks(name, type, startTime, duration, startDate);
        // TODO: use verifyTask()
        //if (verifyTask(newTask)){
        //
        schedule.createTransientTask(name, type, startTime, duration, startDate);
        return true;
        //} else return false;
    }
    public static boolean createRecurringTask(String name, String type, int startDate,
                                              Float startTime, Float duration,
                                              int endDate, int frequency){
        RecurringTasks newTask = new RecurringTasks(name, type, startTime, duration, startDate, endDate, frequency);
        // TODO: use verifyTask()
        // if(verifyTask(newTask){
        schedule.createRecurringTask(name, type, startDate, duration, startTime, endDate, frequency);
        return true;
        //} else return false;
    }
    public static boolean createAntiTask(String name, String type, int startDate,
                                         Float startTime, Float duration){
        AntiTasks newTask = new AntiTasks(name, type, startTime, duration, startDate);
        // TODO: use verifyTask()
        // if(verifyTask(newTask){
        schedule.createAntiTask(name, type, startDate, duration, startTime);
        return true;
        //} else return false;
    }

    public static boolean verifyTask(Tasks task){
        boolean pass = true;

//        check all common attributes

//        verify start time
        if ((task.getStartTime() < 0) || (task.getStartTime() > 23.75)){
            pass = false;
            //delete later
            System.out.println("invalid start time");
        }

        //verify duration of task
        if ((task.getDuration() < 0.25) || (task.getDuration() > 23.75)){
            pass = false;
            //delete later
            System.out.println("invalid duration");
        }

       //checks specific to task type
        if (task instanceof TransientTasks){
            //delete later
            System.out.println("is transient");
            //check overlap with transient or recurring tasks
//              get task list and iterate through. if same date and same startTime return false
//              or if startTime is within duration of another task return false
        }

        if (task instanceof RecurringTasks){
            //verify end date
            if (task.getStartDate() >= ((RecurringTasks) task).getEndDate()){
                pass = false;
            }

            //verify frequency here


            //calculate occurrence
//            int i = 0;
//            int f = ((RecurringTasks) task).getFrequency();

            //loop through frequency and for each iteration, create a recurring task with date set to startDate + frequency
            //check overlap with recurring or transient tasks

        }

        if (task instanceof AntiTasks) {
            //check overlap with transient or antitasks
            //check overlap with recurring tasks
        }
        return pass;
    }
    public static Tasks findTask(String name){
        Tasks exampleTask = new Tasks("task", "transient", 0f, 0f, 0);
        return exampleTask;
    }
    public static boolean deleteTask(String name){
        return true;
    }

    public static boolean writeSchedule(String filename) {
        JSONObject jsonObject = new JSONObject();
        Vector<Tasks> tasksVector = new Vector<Tasks>();
//        for (Tasks task: tasksVector) {
//           // getTasklist()
//        }
        // for each task in the vector
        // add a new json object & put each attribute of the task into the object
        try {
            FileWriter file = new FileWriter(filename);

            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) { // IOException thrown when reading/accessing files fails at any point
            e.printStackTrace();
        }
        return true;
    }

    public static boolean readSchedule (String filename) {
        JSONParser parser = new JSONParser();
        Tasks tasks = null; // initialize task??
        if (verifyTask(tasks) == true) { // verify task -- pass in task name
            try {
                Object obj = parser.parse(new FileReader(filename));
                JSONObject jsonObject = (JSONObject) obj;
                Set<String> keyset = jsonObject.keySet(); // iterate to get the key/pair values -- work in progress
                Iterator<String> keys = keyset.iterator();
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = jsonObject.get(key);
                    System.out.println(key + " " + value);
                }
            } catch (FileNotFoundException e) { // FileNotFoundException should throw an error if file is not found in directory files/folder
                e.printStackTrace();
            } catch (ParseException e) { // ParseException should throw an error if the file is not json type/format
                e.printStackTrace();
            } catch (IOException e) { // IOException thrown when reading/accessing files fails at any point
                e.printStackTrace();
            }
        }
        else {
           System.out.print("Error in adding tasks to schedule. ");
        }
        return true;
    }

}
