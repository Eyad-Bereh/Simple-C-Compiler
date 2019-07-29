package nodes;

public class conditionNode extends treeNode {
	
	public Object execute() {
		//System.out.println("Condition Node Has Been Visited");
		String v1 = children.get(0).execute().toString();
		String v2 = children.get(1).execute().toString();
		String operator = children.get(2).execute().toString();
		
		// v1.matches("-?\\d+(\\.\\d+)?")
		if (typeCheck.isNumeric(v1) &&
			typeCheck.isNumeric(v2)) {
			double double_v1 = Double.parseDouble(v1);
			double double_v2 = Double.parseDouble(v2);
			
			if (operator.equals("==")) {
				return (double_v1 == double_v2);
			}
			else if (operator.equals("!=")) {
				return (double_v1 != double_v2);
			}
			
			else if (operator.equals("<=")) {
				return (double_v1 <= double_v2);
			}
			else if (operator.equals(">=")) {
				return (double_v1 >= double_v2);
			}
			else if (operator.equals("<")) {
				return (double_v1 < double_v2);
			}
			else if (operator.equals(">")) {
				return (double_v1 > double_v2);
			}
		}
		else {
			String string_v1 = v1.toString();
			double double_v1 = Double.parseDouble(variablesStorage.getValue(string_v1).getValue().toString());
			double double_v2 = Double.parseDouble(v2);
			
			if (operator.equals("==")) {
				return (double_v1 == double_v2);
			}
			else if (operator.equals("!=")) {
				return (double_v1 != double_v2);
			}
			else if (operator.equals("<=")) {
				return (double_v1 <= double_v2);
			}
			else if (operator.equals(">=")) {
				return (double_v1 >= double_v2);
			}
			else if (operator.equals("<")) {
				return (double_v1 < double_v2);
			}
			else if (operator.equals(">")) {
				return (double_v1 > double_v2);
			}
			
			
		}
		return true;
	}

}
