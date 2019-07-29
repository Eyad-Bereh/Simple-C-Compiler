package nodes;

public class gotoNode extends treeNode {

	@Override
	public Object execute() {
		//System.out.println("Goto Node Has Been Visited");
		while (true) {
			for (int i = 1; i < children.size(); i++) {
				children.get(i).execute();
			}
		}
	}
}
