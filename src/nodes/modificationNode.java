package nodes;

public class modificationNode extends treeNode {
	
	@Override
	public Object execute() {
		//System.out.println("Modification Node Has Been Visited");
		String variableName = (String)children.get(0).execute();
		if (!variablesStorage.variables.containsKey(variableName)) {
			return null;
		}
		
		variable var = variablesStorage.variables.get(variableName);
		
		if (children.size() == 2) {
			Double value = Double.parseDouble(variablesStorage.variables.get(variableName).getValue().toString());
			String operator = (String)children.get(1).execute();
			if (operator.equals("++")) {
				value += 1;
			}
			else if (operator.equals("--")) {
				value -= 1;
			}
			variable variableEntry = new variable(var.getType(), var.getSize(), var.getAddress());
			variableEntry.setValue(value.toString());
			variablesStorage.variables.put(variableName, variableEntry);
			return value;
		}
		
		Double change = Double.parseDouble(children.get(1).execute().toString());
		String operator = (String)children.get(2).execute();
		Double current = null;
		
		if (var.getType().equals("int")) {
			//current = Integer.parseInt(var.getValue());
			current = Double.parseDouble(var.getValue().toString());
		}
		else if (var.getType().equals("float")) {
			//current = Float.parseFloat(var.getValue());
			current = Double.parseDouble(var.getValue().toString());
		}
		else if (var.getType().equals("double")) {
			current = Double.parseDouble(var.getValue().toString());
		}
		
		
		if (operator.equals("=")) {
			current = change;
		}
		else if (operator.equals("+=")) {
			current += Double.parseDouble(change.toString());
		}
		else if (operator.equals("-=")) {
			current -= change;
		}
		else if (operator.equals("*=")) {
			current *= change;
		}
		else if (operator.equals("/=")) {
			current /= change;
		}
		else if (operator.equals("%=")) {
			current %= change;
		}
		else if (operator.equals(">>=")) {
			Double temp1 = new Double(current);
			Double temp2 = new Double(change);
			int current_temp = temp1.intValue();
			int change_temp = temp2.intValue();
			current_temp >>= change_temp;
			current = (double) current_temp;
		}
		else if (operator.equals("<<=")) {
			Double temp1 = new Double(current);
			Double temp2 = new Double(change);
			int current_temp = temp1.intValue();
			int change_temp = temp2.intValue();
			current_temp <<= change_temp;
			current = (double) current_temp;
		}
		else if (operator.equals("&=")) {
			Double temp1 = new Double(current);
			Double temp2 = new Double(change);
			int current_temp = temp1.intValue();
			int change_temp = temp2.intValue();
			current_temp &= change_temp;
			current = (double) current_temp;
		}
		else if (operator.equals("|=")) {
			Double temp1 = new Double(current);
			Double temp2 = new Double(change);
			int current_temp = temp1.intValue();
			int change_temp = temp2.intValue();
			current_temp |= change_temp;
			current = (double) current_temp;
		}
		else if (operator.equals("^=")) {
			Double temp1 = new Double(current);
			Double temp2 = new Double(change);
			int current_temp = temp1.intValue();
			int change_temp = temp2.intValue();
			current_temp <<= change_temp;
			current = (double) current_temp;
		}
		
		variable variableEntry = new variable(var.getType(), var.getSize(), var.getAddress());
		variableEntry.setValue(current.toString());
		variablesStorage.variables.put(variableName, variableEntry);
		
		return current;
	}

}
