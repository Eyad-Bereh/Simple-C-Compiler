package nodes;

public class constantNode extends treeNode {
	private Object value;
	private boolean isVariable;
	private String unaryOperator = null;
	private String postfixOperator = null;
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public void setValue(Object value, boolean isVariable) {
		this.value = value;
		this.isVariable = isVariable;
	}
	
	public boolean isValueVariable() {
		return this.isVariable;
	}
	
	public void setUnaryOperator(String unaryOperator) {
		this.unaryOperator = unaryOperator;
	}
	
	public void setPostfixOperator(String postfixOperator) {
		this.postfixOperator = postfixOperator;
	}
	
	public constantNode Operation(String op, constantNode destination) {
		constantNode temp = new constantNode();
		Double v1 = null; //Double.parseDouble(this.value.toString());
		Double v2 = null; //Double.parseDouble(destination.execute().toString());
		
		if (this.isValueVariable()) {
			v1 = Double.parseDouble(variablesStorage.variables.get(this.value.toString()).toString());
		}
		else {
			v1 = Double.parseDouble(this.execute().toString());
		}
		
		if (destination.isValueVariable()) {
			v2 = Double.parseDouble(variablesStorage.variables.get(destination.execute().toString()).getValue().toString());
		}
		else {
			v2 = Double.parseDouble(destination.execute().toString());
		}
		
		if (op == "|") {
			temp.setValue(v1.intValue() | v2.intValue());
		}
		else if (op == "^") {
			temp.setValue(v1.intValue() ^ v2.intValue());
		}
		else if (op == "&") {
			temp.setValue(v1.intValue() & v2.intValue());
		}
		else if (op == "<<") {
			temp.setValue(v1.intValue() << v2.intValue());
		}
		else if (op == ">>") {
			temp.setValue(v1.intValue() >> v2.intValue());
		}
		else if (op == "+") {
			temp.setValue(v1 + v2);
		}
		else if (op == "-") {
			temp.setValue(v1 - v2);
		}
		else if (op == "*") {
			temp.setValue(v1 * v2);
		}
		else if (op == "/") {
			temp.setValue(v1 / v2);
		}
		else if (op == "%") {
			temp.setValue(v1 % v2);
		}
		
		return temp;
	}
	
	public Object execute() {
		//System.out.println("Constant Node Has Been Visited");
		if (this.isVariable) {
			Object temp = variablesStorage.getValue(this.value.toString()).getValue();
			if (typeCheck.isNumeric(temp)) {
				if (this.unaryOperator == "+") {
					return Double.parseDouble(temp.toString());
				}
				else if (this.unaryOperator == "-") {
					return -Double.parseDouble(temp.toString());
				}
				else if (this.unaryOperator == "~") {
					//Double temp = new Double(value);
					//return ~temp.intValue();
					return ~(new Double(Double.parseDouble(temp.toString())).intValue());
				}
				else {
					return Double.parseDouble(temp.toString());
				}
			}
			return temp;
		}
		else if (typeCheck.isNumeric(this.value)) {
			if (this.unaryOperator == "+") {
				return Double.parseDouble(this.value.toString());
			}
			else if (this.unaryOperator == "-") {
				return -Double.parseDouble(this.value.toString());
			}
			else if (this.unaryOperator == "~") {
				//Double temp = new Double(value);
				//return ~temp.intValue();
				return ~(new Double(Double.parseDouble(this.value.toString())).intValue());
			}
			else {
				return Double.parseDouble(this.value.toString());
			}
		}
		else if (typeCheck.representsCharacter(this.value.toString())) {
			Character temp = this.value.toString().substring(0, 2).charAt(1);
			return temp;
		}
		return this.value;
	}

}
