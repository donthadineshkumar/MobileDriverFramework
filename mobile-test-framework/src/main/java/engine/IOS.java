package engine;

/** 
 * 
 * @author Raj
 * @description:  Iphone family
 */
public class IOS implements MobilePhone {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("IOS init");
	}

	@Override
	public void toggleWifi(String State) {
		// TODO Auto-generated method stub
		System.out.println("IOS toggleWifi");
	}

	@Override
	public void makeCall(String phoneNum) {
		// TODO Auto-generated method stub
		System.out.println("IOS makeCall");
	}

	@Override
	public void sendSMS(String smsMsg, String phoneNum) {
		// TODO Auto-generated method stub
		System.out.println("IOS sendSMS");
	}

	@Override
	public void pickWheelItem(String value) {
		// TODO Auto-generated method stub
		System.out.println("IOS PickWheelItem");
	}

	@Override
	public void getDescription(String value) {
		// TODO Auto-generated method stub
		
	}




	
	
}
