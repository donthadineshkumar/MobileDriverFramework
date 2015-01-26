package engine;

import org.testng.ITestContext;

public class MobilePhoneFactory {

	static final String IPHONE = "IPHONE";
	static final String ANDRIOD = "ANDRIOD";
	
	   public MobilePhone getPhone(String phoneType) {
	      if(phoneType == null){
	    	 System.out.println("No Phone Type Found");
	         return null;
	      }		
	      if(phoneType.equalsIgnoreCase(IPHONE)) {
	    	    return new IOS();
	         
	      } else if(phoneType.equalsIgnoreCase(ANDRIOD)){
	    	    return new ANDRIOD();
	      }
		return null;
	   }
	   
	   
}
