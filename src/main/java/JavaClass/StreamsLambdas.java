package JavaClass;

import org.junit.Test;

import java.util.ArrayList;

public class StreamsLambdas {

    @Test
    public void regular(){

        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        //add Stream - as collection of strings - to use lambda & filter we have to convert list into stream
        //stream scans all of extpressions paralelly
        names.stream().filter(s -> s.startsWith("A"));

        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }


    }
}
