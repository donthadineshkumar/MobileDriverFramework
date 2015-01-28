package engine;

import org.testng.ITestContext;

import IOS_TYPES.Iphone6;
import IOS_TYPES.SamsungGS5;

public class MobilePhoneFactory {
	static final String IPHONE = "IPHONE";
	static final String ANDRIOD = "ANDRIOD";
	static final String Iphone6 = "Iphone6";
	static final String SamsungGS5 = "SamsungGS5";
	
	   public static MobilePhone getPhone(String phoneType) {
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
	   
	   public static MobilePhone getPhoneType(String phoneModel) {
		      if(phoneModel == null){
		    	 System.out.println("No Phone Model Found...");
		         return null;
		      }		
		      if(phoneModel.equalsIgnoreCase(Iphone6)) {
		    	    return new Iphone6();
		    	    
		      } else if(phoneModel.equalsIgnoreCase(SamsungGS5)){
		    	    return new SamsungGS5();
		      }  	    
			return null;
		   }

		/* Private Constructor  */
		private MobilePhoneFactory () {
			
		}
}
