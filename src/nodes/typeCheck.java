package nodes;

public class typeCheck {
	public static boolean isInteger(Object parameter) {
		try {
			Integer.parseInt(parameter.toString());
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isNumeric(Object parameter) {
		try {
            Long.parseLong(parameter.toString());
        }
        catch (Exception e1) {
            try {
                Double.parseDouble(parameter.toString());
            }
            catch(Exception e2) {
                return false;
            }
        }
        return true;
	}
	
	public static boolean representsCharacter(String parameter) {
		/*
		 * Handling characters of the form 'a'
		 */
		if (parameter.length() == 3 && 
			parameter.charAt(0) == '\'' &&
			parameter.charAt(2) == '\'') {
			return true;
		}
		/*
		 * Handling characters of the form '\n'
		 */
		else if (parameter.length() == 4 && 
			parameter.charAt(0) == '\'' &&
			parameter.charAt(1) == '\\' &&
			parameter.charAt(3) == '\'') {
			return true;
		}
		return false;
	}
	
	public static boolean representsString(Object parameter) {
		String temp = parameter.toString();
		if (temp.charAt(0) == '\"' &&
			temp.charAt(temp.length() - 1) == '\"') {
			return true; 
		} 
		return false;
	}
}
