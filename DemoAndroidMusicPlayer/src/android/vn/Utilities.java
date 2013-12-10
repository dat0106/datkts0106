package android.vn;

public class Utilities {
	
	public String milliSecondsToTimer(long milliseconds){
		String finalTimerString = "";
		String secondsString = "";
		
		//Chuyển đổi thời gian sang định dạng Hours:Minutes:Seconds
		   int hours = (int)( milliseconds / (1000*60*60));
		   int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
		   int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
		   //Thêm giờ nếu có
		   if(hours > 0){
			   finalTimerString = hours + ":";
		   }
		   
		   //Thêm vào số 0 nếu có 1 chữ số
		   if(seconds < 10){ 
			   secondsString = "0" + seconds;
		   }else{
			   secondsString = "" + seconds;
		   }		   
		   finalTimerString = finalTimerString + minutes + ":" + secondsString;
		
		//kết quả trả về
		return finalTimerString;
	}
	
	public int getProgressPercentage(long currentDuration, long totalDuration){
		Double percentage = (double) 0;
		
		long currentSeconds = (int) (currentDuration / 1000);
		long totalSeconds = (int) (totalDuration / 1000);
		
		//Tính toán tỉ lệ %
		percentage =(((double)currentSeconds)/totalSeconds)*100;
		
		//trả về giá trị %
		return percentage.intValue();
	}

	public int progressToTimer(int progress, int totalDuration) {
		int currentDuration = 0;
		totalDuration = (int) (totalDuration / 1000);
		currentDuration = (int) ((((double)progress) / 100) * totalDuration);
		
		//trả về thời gian hiện tại trong mili giây
		return currentDuration * 1000;
	}
}
