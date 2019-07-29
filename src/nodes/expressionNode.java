package nodes;

public class expressionNode extends treeNode {
	public int size() {
		return this.children.size();
	}

	@Override
	public Object execute() {
		/*
		if (children.size() == 0) {
			return null;
		}
		*/
		//-?\\d+(\\.\\d+)?
		Object returnedValue = null;
		//System.out.println(children.size());
		System.out.println(children.size());
		if (children.size() == 1) {
			try {
				returnedValue = children.get(0);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else if (children.size() == 3) {
			Object value1 = children.get(0).execute();
			Object op = children.get(1).execute().toString();
			Object value2 = children.get(2).execute();
			
			Double v1 = new Double(value1.toString());
			Double v2 = new Double(value2.toString());
						
			
			
			switch(op.toString()) {
				case "+":
					returnedValue = v1.doubleValue() + v2.doubleValue();
					//System.out.println(v1 + " + " + v2 + " = " + returnedValue);
					break;
				
				case "-":
					//System.out.println(v1 + " - " + v2 + " = " + returnedValue);
					returnedValue = v1.doubleValue() - v2.doubleValue();
					break;
			}
		}
		@SuppressWarnings("unused")
		int z = 5;
		z++;
		return returnedValue;
	} 

}
