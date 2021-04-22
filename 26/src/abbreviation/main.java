package abbreviation;

/*
Напишите функцию, создающую аббревиатуры. Например, на входе строка:
"Санкт-Петербургский Государственный Технический Институт им. Патриса Лумумбы".
На выходе строка: СПБГТИПЛ.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        String s = "Институт Компьютерных Наук и Технологий";
        char A = 'А';
        char Z = 'Я';
        int a = A;
        int z = Z;
        char[] array_char1;
        char[] array_char2;
        int length_array1 = 0;
        int length_array2 = 0;
        int t = 0;

        /*
        Pattern pattern = Pattern.compile("[А-Я]");
        Matcher matcher1 = pattern.matcher(s);
        */

        array_char1 = s.toCharArray();
        length_array1 = array_char1.length;
        //System.out.println(a);

        for(int i=0; i<length_array1; i++){
            if(a<=array_char1[i] && array_char1[i] <= z){
                length_array2++;
            }
        }

        array_char2 = new char[length_array2];

        for(int i=0; i<length_array1; i++){
            if(a<=array_char1[i] && array_char1[i] <= z){
                array_char2[t]=array_char1[i];
                t++;
            }
        }

        System.out.println(array_char2);

    }
}
