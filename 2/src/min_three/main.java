package min_three;

/*
реализуйте метод int min(int a, int b, int c),
находящий минимальный из трех аргументов без использования
утилитарных функций стандартной библиотеки Java.
 */

public class main {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int m = 0;

        System.out.println("a="+a+" b="+b+" c="+c);

        m=min(a, b, c);
        System.out.println("min="+m);
    }

    public static int min(int a, int b, int c){
        int m = 0;
        if(a>b){
            if(a>c){
                if(b>c){
                    m=c;
                }
                else {
                    m=b;
                }
            }
            else {
                m=b;
            }
        }
        else {
            if(a>c){
                m=c;
            }
            else {
                m=a;
            }
        }
        return m;
    }
}
