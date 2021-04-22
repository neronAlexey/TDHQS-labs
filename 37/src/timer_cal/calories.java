package timer_cal;

public class calories {

    public static int view_trening(String view_tren){
        int spen_cal = 0;
        switch (view_tren){
            case "Присидание":
                spen_cal = 150;
                break;
            case "Отжимание":
                spen_cal = 200;
                break;
            case "Скакалка":
                spen_cal = 250;
                break;
        }
        return spen_cal;
    }


    public static int spent_calories(int cal, int t){
        int spent_cal = 0;
         spent_cal = cal*t;
         return spent_cal;
    }
}
