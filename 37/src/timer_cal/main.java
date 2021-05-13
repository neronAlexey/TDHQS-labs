package timer_cal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class main {
    public static String[] open_fail() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\политех\\3 курс\\2 семестр\\Технологии разработки качественного программного обеспечения\\Технологии разработки качественного программного обеспечения Лабараторные\\37\\src\\timer_cal\\save.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                System.out.println(str);
            }
        }
        String[] stringArr = list.toArray(new String[0]);
        //System.out.println(stringArr[0]);
        return stringArr;

    }
}



