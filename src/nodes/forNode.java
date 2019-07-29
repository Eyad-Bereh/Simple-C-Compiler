package nodes;
import exceptions.*;

public class forNode extends treeNode {

	@Override
	public Object execute() {
		Object begin = null;
		String varname = null;
		boolean isTemp = false;
		try {
			begin = children.get(0).execute();
		}
		catch (VariableAlreadyExistException e) {
			isTemp = true;
			varname = children.get(0).children.get(1).execute().toString();
			Object value = variablesStorage.variables.get(varname).getValue();
			variablesStorage.tempValues.push(value);
			value = children.get(0).children.get(2).execute().toString();
			variablesStorage.variables.get(varname).setValue(value);
		}
		
		Boolean condition = Boolean.parseBoolean(children.get(1).execute().toString());
		
		while (Boolean.parseBoolean(children.get(1).execute().toString())) {
			children.get(3).execute();
			children.get(2).execute();
		}
		
		if (isTemp) {
			Object end = variablesStorage.tempValues.pop();
			variablesStorage.variables.get(varname).setValue(end);
		}
		return null;
	}

}
