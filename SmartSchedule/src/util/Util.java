package util;

public class Util {
    public static String convertTime(Integer time){
        if(time < 10){
            return "0" +  time.toString();
        }
        return time.toString();
    }
}
