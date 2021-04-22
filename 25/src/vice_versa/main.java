package vice_versa;

/*
Напишите программу, отображающую переданную строку задом наперёд. Напишите тесты.
 */

public class main {
    public static void main(String[] args) {

        char[] array_char1;
        char[] array_char2;
        int length_array = 0;
        int length_array2 = 0;


        String s = "Write a program that displays the passed string backwards. Write tests.";
        array_char1 = s.toCharArray();
        length_array = array_char1.length;
        array_char2 = new char[length_array];

        length_array2 = length_array-1;


        //System.out.println(length_array2);
        for(int i=0; i < length_array; i++){
            array_char2[i] = array_char1[length_array2];
            length_array2 = length_array2-1;
        }

        System.out.println(array_char1);
        System.out.println(array_char2);

    }

}
