package nodes;

public class caseNode extends treeNode {
	private boolean hasBreakStatement;
	
	public void setHasBreakStatement(boolean hasBreakStatement) {
		this.hasBreakStatement = hasBreakStatement;
	}
	
	public boolean hasBreakStatement() {
		return this.hasBreakStatement;
	}

	public Object getExpressionValue() {
		return this.children.get(0).execute();
	}
	
	@Override
	public Object execute() {
		this.children.get(1).execute();
		return null;
	}

}
