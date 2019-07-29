package nodes;
import java.util.HashMap;
import java.util.Stack;
import exceptions.*;

public final class variablesStorage {
	public static HashMap<String, variable> variables = new HashMap<String, variable>();
	public static Stack<Object> tempValues = new Stack<Object>();
	public static boolean[] markedAddresses = new boolean[0xFFFFF];

	public static boolean variableExist(String varname) {
		if (!variablesStorage.variables.containsKey(varname)) {
			return false;
		}
		return true;
	}
	
	public static variable getValue(String varname) {
		if (!variableExist(varname)) {
			throw new NoSuchVariableException(varname);
		}
		
		variable temp = variables.get(varname);
		return temp;
	}
}
