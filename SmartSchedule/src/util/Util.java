package util;

public class Util {
    public static String convertTime(Integer time){
        if(time < 10){
            return "0" +  time.toString();
        }
        return time.toString();
    }

    public static String getTime(String asString) {
    	if(asString == null){
    		return "--";
    	}
    	return asString;
	}

    public  static boolean intToBool(Integer integer) {
		if (integer == 1) {
			return true;
		}
		return false;
	}

}
