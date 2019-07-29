package nodes;

public class switchNode extends treeNode {

	@Override
	public Object execute() {
		Object value = children.get(0).execute();
		caseNode cNode = new caseNode();
		defaultNode dNode = new defaultNode();
		int size;
		boolean hasDefaultNode;
		boolean transferControlFlow = false;
		if (children.get(children.size() - 1) instanceof defaultNode) {
			size = children.size() - 1;
			hasDefaultNode = true;
		}
		else {
			size = children.size();
			hasDefaultNode = false;
		}
		
		for (int i = 1; i < size; i++) {
			cNode = (caseNode) children.get(i);
			if (cNode.children.get(0).execute().equals(value)) {
				cNode.children.get(1).execute();
				if (!cNode.hasBreakStatement()) {
					transferControlFlow = true;
					continue;
				}
				else {
					transferControlFlow = false;
					break;
				}
			}
		}
		
		if (hasDefaultNode && transferControlFlow) {
			children.get(size).execute();
		}
		return null;
	}

}
