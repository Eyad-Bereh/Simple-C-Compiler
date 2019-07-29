package nodes;

public class ifNode extends treeNode {

	public Object execute() {
		//System.out.println("If Node Has Been Visited");
		for (int i = 0; i < children.size(); i++) {
			children.get(i).execute();
		}
		return null;
	}

}
