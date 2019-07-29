package nodes;

public class doWhileNode extends treeNode {

	@Override
	public Object execute() {
		//System.out.println("While Node Has Been Visited");
		do {
			for (int i = 0; i < children.size() - 1; i++) {
				children.get(i).execute();
			}
		}
		while ((boolean)children.get(children.size() - 1).execute());
		return null;
	}

}
