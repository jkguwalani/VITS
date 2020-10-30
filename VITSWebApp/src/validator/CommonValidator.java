package validator;

public class CommonValidator {

	public static boolean validateString(String inputString){
		System.out.println("CommonValidator.validateString.inputString = " + inputString);
		if((inputString == null) || ("null".equals(inputString) || ("".equals(inputString)))){
			return false;
		}else{
			return true;
		}
	}
	public static boolean equals(String str1, String str2){
		String strobj1 = str1;
		String strobj2 = str2;
		
		System.out.println("CommonValidator.equals.sr1 = " + str1);
		System.out.println("CommonValidator.equals.sr2 = " + str2);
		
		strobj1 = strobj1.toLowerCase().trim();
		strobj2 = strobj2.toLowerCase().trim();
		
		if((CommonValidator.validateString(strobj1)) && (CommonValidator.validateString(strobj2))){
			
			System.out.println("CommonValidator.equals.String1 = " + strobj1);
			System.out.println("CommonValidator.equals.String2 = " + strobj2);
			
			if(strobj1.equals(strobj2)){
				return true;
			}
			else{
				return false;
			}
		}
		else{	 
			return false;
		}
	}
	
}
