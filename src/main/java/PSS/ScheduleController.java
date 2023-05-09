package PSS;

import java.io.IOException;
import java.io.*;
import java.util.*;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

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

    public static void writeSchedule(String filename){
        JSONParser parser = new JSONParser();
        // Iterate over JSONObject print all properties and their values (All details from Schedule)
        try {
            JSONObject json = (JSONObject) parser.parse(filename);
            Set<String> keyset = json.keySet();
            Iterator<String> keys = keyset.iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = json.get(key);
                FileWriter file = new FileWriter(filename);
                file.write(json.toJSONString()); // write Schedule into JSON
                file.close();
                System.out.println( key +" : " + value); // print statement to make sure it gets key/value correctly
            }
        } catch (IOException e) { // IOException thrown when reading/accessing files fails at any point
            e.printStackTrace();
        } catch (ParseException e) { // ParseException should throw an error if the file is not json type/format
            e.printStackTrace();
        }
    }

    public static void readSchedule (String filename) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject)obj;
            Scanner scan = new Scanner(filename);
            System.out.print((String)jsonObject.get(scan.nextLine())); // read each line one by one -- need to double-check this line
            // String name = (String)jsonObject.get("Name"); example code to get text from JSON file
        } catch (FileNotFoundException e) { // FileNotFoundException should throw an error if file is not found in directory files/folder
            e.printStackTrace();
        } catch (ParseException e) { // ParseException should throw an error if the file is not json type/format
            e.printStackTrace();
        } catch (IOException e) { // IOException thrown when reading/accessing files fails at any point
            e.printStackTrace();
        }
        // check for errors in the file after reading (tasks cannot overlap, or have invalid/inconsistent details)
    }

    public static void readSchedule (Schedule filename) {

    }
}
