package nodes;

import java.text.DecimalFormat;

public class stringNode extends treeNode {	
	String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public Object execute() {
		//System.out.println("String Node Has Been Visited");
		return this.value;
	}

}
