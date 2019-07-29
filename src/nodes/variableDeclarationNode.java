package nodes;

import exceptions.*;

public class variableDeclarationNode extends treeNode {
	
	@Override
	public Object execute() {
		//System.out.println("Variable Declaration Node Has Been Visited");
		String type = children.get(0).execute().toString();
		String name = children.get(1).execute().toString();
		Object value = children.get(2).execute();
		
		variable variableEntry = null;
		
		if (variablesStorage.variables.containsKey(name)) {
			throw new VariableAlreadyExistException(name);
		}
		
		if (type.equals("int")) {
			if (value == null) {
				variableEntry = new variable("int", value.toString(), 4);
				return null;
			}
			String temp = value.toString();
			if (temp.length() != 1 && temp.charAt(0) == '0') {
				if (temp.charAt(1) == 'x' ||
					temp.charAt(1) == 'X') {
					value = temp.substring(2, temp.length());
					Double tempVal = new Double(value.toString());
					value = String.valueOf(tempVal.intValue());
					value = Integer.parseInt(value.toString(), 16);
				}
				else {
					Double tempVal = new Double(value.toString());
					value = String.valueOf(tempVal.intValue());
					value = Integer.parseInt(value.toString(), 8);
				}
			}
			else {
				Double tempVal = new Double(temp);
				value = tempVal.intValue();
			}
			variableEntry = new variable("int", value.toString(), 4);
		}
		else if (type.equals("float")) {
			if (value == null) {
				variableEntry = new variable("int", value.toString(), 4);
				return null;
			}
			value = Float.parseFloat(value.toString());
			variableEntry = new variable("float", value.toString(), 4);
		}
		else if (type.equals("double")) {
			value = Double.parseDouble(value.toString());
			variableEntry = new variable("double", value.toString(), 8);
		}
		else if (type.equals("char")) {
			value = new Character(value.toString().substring(0,2).charAt(1));
			variableEntry = new variable("char", value.toString(), 1);
		}
		//System.out.println("Variable (" + name + ") has the the type: " + variableEntry.getType() + " and the value: " + variableEntry.getValue());
		
		variablesStorage.variables.put(name, variableEntry);
		return null;
	}

}
