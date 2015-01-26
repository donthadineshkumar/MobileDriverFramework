package test;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;

import engine.MobileBaseDriver;
import engine.MobilePhone;
import engine.MobilePhoneFactory;

public class TestCaseExample extends MobileBaseDriver {
	private MobileDriver driver;
	private IMobileDevice device;
	private IMobileWebDriver visualDriver;
	private IMobileWebDriver nativeDriver;
	private IMobileWebDriver domDriver;
	MobilePhoneFactory MobileFactory = new MobilePhoneFactory();
//	MobileBaseDriver MobileBaseDriver = new MobileBaseDriver();
	MobilePhone IOS = MobileFactory.getPhone("IPHONE");
	MobilePhone ANDRIOD = MobileFactory.getPhone("ANDRIOD");
	
	
	@Test
	public void TestCase1 (ITestContext context){

		device.home();	
		
		IOS.pickWheelItem("IPHONE");
		IOS.sendSMS("smsMsg", "");
		IOS.makeCall("");
		IOS.toggleWifi("");
      
		ANDRIOD.pickWheelItem("ANDRIOD");
		ANDRIOD.sendSMS("smsMsg", "");
		ANDRIOD.makeCall("");
		ANDRIOD.toggleWifi("");
		
		System.out.println("Test");
	}
	 
	 
	
	
	 	@BeforeTest
		public void setup(ITestContext context) {
			System.out.println("deviceID: " + context.getCurrentXmlTest().getParameter("deviceid"));
			engineSetup(context);
			device = getDevice();
			driver = getDriver();
			visualDriver = getVisualdriver();
			nativeDriver = getNativedriver();
			domDriver = getdomDriver();
			device.open();		
		} 
	 	
		@AfterTest
		public void destroy() {
			device.close();
			driver.quit();
		} 
		
		
		// public static void main(String[] args) {
		// }
		 
}

