package engine;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.MobileProxy;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;

public abstract class MobileBaseDriver {
	
	private static MobileDriver driver;
	private static IMobileDevice device;
	private static IMobileWebDriver domDriver;
	private static IMobileWebDriver visualDriver;
	private static IMobileWebDriver nativeDriver;
	private static ITestContext context;
	
	public void engineSetup(ITestContext context) {
		setContext(context);
		String cloudURL = context.getCurrentXmlTest().getParameter("cloudURL");
		String UserName = context.getCurrentXmlTest().getParameter("userId");
		String pass = context.getCurrentXmlTest().getParameter("pass");

		try {
			if (context.getCurrentXmlTest().getParameter("Run_Mode").equals("Debug")) {
				driver = new MobileDriver();
			} else if (context.getCurrentXmlTest().getParameter("Run_Mode").equals("Automation")) {
				driver = new MobileDriver(cloudURL, UserName, pass);
			} else if (context.getCurrentXmlTest().getParameter("proxy").equals("True")) {
				String proxyAddress = context.getCurrentXmlTest().getParameter("proxyAddress");
				String proxyPort = context.getCurrentXmlTest().getParameter("proxyPort");	
				MobileProxy proxy = new MobileProxy(proxyAddress, Integer.parseInt(proxyPort), UserName, pass);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.PROXY,proxy);
				driver = new MobileDriver(capabilities);	
			}
		} catch (Exception e) {
			System.out.printf("Not able to set mobile driver object", e);
		}
		
		device = driver.getDevice(context.getCurrentXmlTest().getParameter("defaultdeviceID"));
		domDriver = device.getDOMDriver();
		visualDriver = device.getVisualDriver();
		nativeDriver = device.getNativeDriver();
	}

	public MobileDriver createDriverProxyObject() {		
		return null;
	}

	public static MobileDriver getDriver() {
		return driver;
	}

	public static void setDriver(MobileDriver driver) {
		MobileBaseDriver.driver = driver;
	}

	public static IMobileDevice getDevice() {
		return device;
	}

	public static void setDevice(IMobileDevice device) {
		MobileBaseDriver.device = device;
	}

	public static IMobileWebDriver getdomDriver() {
		return domDriver;
	}

	public static void setdomDriver(IMobileWebDriver domdriver) {
		MobileBaseDriver.domDriver = domdriver;
	}

	public static IMobileWebDriver getVisualdriver() {
		return visualDriver;
	}

	public static void setVisualdriver(IMobileWebDriver visualdriver) {
		MobileBaseDriver.visualDriver = visualdriver;
	}

	public static IMobileWebDriver getNativedriver() {
		return nativeDriver;
	}

	public static void setNativedriver(IMobileWebDriver nativedriver) {
		MobileBaseDriver.nativeDriver = nativedriver;
	}
	public static ITestContext getContext() {
		return context;
	}

	public static void setContext(ITestContext context) {
		MobileBaseDriver.context = context;
	}
}
