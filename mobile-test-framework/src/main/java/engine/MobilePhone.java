package engine;



public interface MobilePhone {

	/* Contains all methods that are common to all Mobile Phone Family */

	public void init();
	public void toggleWifi(String State);
	public void makeCall(String phoneNum);
	public void sendSMS(String smsMsg, String phoneNum);
	public void pickWheelItem(String value);
	
	
	
}
