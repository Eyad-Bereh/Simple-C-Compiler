package nodes;

// A special node to handle the default case in a switch block

public class defaultNode extends treeNode {

	@Override
	public Object execute() {
		children.get(0).execute();
		return null;
	}

}
