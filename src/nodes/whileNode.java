package nodes;

public class whileNode extends treeNode {

	@Override
	public Object execute() {
		//System.out.println("While Node Has Been Visited");
		while ((boolean)children.get(0).execute()) {
			for (int i = 1; i < children.size(); i++) {
				children.get(i).execute();
			}
		}
		return null;
	}

}
