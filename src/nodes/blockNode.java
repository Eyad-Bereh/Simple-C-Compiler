package nodes;

public class blockNode extends treeNode {
	public Object execute() {
		//System.out.println("Block Node Has Been Visited");
		for (int i = 0; i < children.size(); i++) {
			children.get(i).execute();
		}
		return null;
	}

}
