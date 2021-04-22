package boolen_swap;
/*
реализуйте метод boolean swap(int i, int j, int[] anArray),
меняющий местами элементы по индексам i и j в массиве anArray и возвращающий false,
если индексы выходят за пределы массива
 */


import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int a = 1;
        int b = 10;
        boolean out = true;
        System.out.println(Arrays.toString(anArray));

        out= swap(a, b, anArray);

        System.out.println(out);
        System.out.println(Arrays.toString(anArray));


    }
    public static boolean swap(int i, int j, int[] anArray){
       boolean out = true;
       int x = 0;

       if( i<0 | j>anArray.length | i>anArray.length | j<0){
           out = false;
       }
       else {
           x = anArray[i];
           anArray[i]=anArray[j];
           anArray[j]=x;
       }
       return out;
    }
}
