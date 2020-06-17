package arrays_and_string;

public class ValidateIPAddress {
	public static String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0){
            return "Neither";
        }
        if (IP.indexOf('.') != -1){
            if (isVlidIPv4(IP)){
                return "IPv4";
            }
        }
        if (IP.indexOf(':') != -1){
            if (isVlidIPv6(IP)){
                return "IPv6";
            }
        }
        return "Neither";
    }

    private static boolean isVlidIPv4(String IP){
    	// split would remove leading and ending empty string
        if(IP.charAt(0)=='.' || IP.charAt(IP.length()-1)=='.') return false;
    	// split, special character
        String[] arr = IP.split("\\.");
        if (arr.length != 4){
            return false;
        }
        for (String s : arr){
            if (!isVlidIPv4Helper(s)){
                return false;
            }
        }
        return true;
    }
    
    private static boolean isVlidIPv4Helper(String s){
        // no leading zeros: string -> int -> original string
        try{
            int val = Integer.parseInt(s);
            return (Integer.toString(val).equals(s) && val >= 0 && val <= 255);
        }catch(NumberFormatException e){
            return false;
        }    
    }
    
    private static boolean isVlidIPv6(String IP){
    	if(IP.charAt(0)==':' || IP.charAt(IP.length()-1)==':') return false;
    	String[] arr = IP.split(":");
        if (arr.length != 8){
            return false;
        }
        for (String s : arr){
            if (!isVlidIPv6Helper(s)){
                return false;
            }
        }
        return true;
    }
    
    private static boolean isVlidIPv6Helper(String s){
        if (s.length() > 4) {
            return false;
        }
        try {
        	// parseInt, the first char can be '-' or '+'
            return Integer.parseInt(s, 16) >= 0  && s.charAt(0) != '-';}
        catch (NumberFormatException e){
            return false;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String IP = "2001:0db8::85a3:0:0:8A2E:0370:7334:";
		String[] a = IP.split(":");
		String res = validIPAddress(IP);
		System.out.println(res);
	}

}
