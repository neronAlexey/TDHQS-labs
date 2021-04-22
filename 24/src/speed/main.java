package speed;
/*
Напишите функцию, на входе которой расстояние до места назначения (S, м)
и время в пути (T, мин). Вычислить скорость (км/ч). Напишите тесты.
 */


public class main {


    public static void main(String[] args) {

        int S = 20;
        int T = 5;
        double V = 0;
        V = speed(S,T);

        System.out.println(V);
    }

    private static double speed(int S, int T) {
        double V = 0;
        double A = 0;
        //double B = 0;
        A = (double)1000/60;
        V = (double)S/T;
        V = (double)V/A;

        return V;
    }

}
