package filerwintoJsonobj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.io.IOException;

// Program reads JSOn file
// loads student atrributes to JSONobject - to be done as assignmentimport org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonfileRW {

    public static void main(String args[]) {

        String jsonfilepath = "C:\\Users\\hitesh\\Ideaprojects\\DataSets\\inputelements.json";
        String outputfilepath = "C:\\Users\\hitesh\\Ideaprojects\\DataSets\\outputelements.json";
        Object students;
        JSONArray ja = new JSONArray();  // SInce JSON file contains array of student details

        // parsing file
        try {
            FileReader fr = new FileReader(jsonfilepath);
            JSONParser parser = new JSONParser();
            ja = (JSONArray) parser.parse(fr);

            // we need JSONArray and not JSONObject.
            //students = parser.parse(fr);
            System.out.println("Printing the whole array thru Object");
            System.out.println(ja);


            System.out.println("\nJSON array size is : " + ja.size());
            System.out.println("Printing the whole array thru JSON Array");
            System.out.println(ja);

            System.out.println("\nPrinting the 5th element of JSON array");
            System.out.println(ja.get(4)); // Get the fifth element


            JSONObject jo;
            System.out.println("\nPrinting value of field Name and Age of all elements of JSON array");

            for (int i = 0; i < ja.size(); i++) {
                jo = (JSONObject) ja.get(i);
                System.out.printf("%s : %s\n", jo.get("Name"), jo.get("Age"));

                System.out.print(((JSONObject) ja.get(i)).get("Name"));// you can write like this also.
                System.out.print(" - ");
                System.out.print((((JSONObject) ja.get(i)).get("Age")));
                System.out.println();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //ReWrite JSON file
        try (FileWriter file = new FileWriter(outputfilepath)) {
            file.write(ja.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
