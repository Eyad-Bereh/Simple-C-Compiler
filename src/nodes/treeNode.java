package nodes;
import java.util.ArrayList;

public abstract class treeNode {
	ArrayList<treeNode> children = new ArrayList<treeNode>();
	
	public void addChild(treeNode node) {
		children.add(node);
	}
	
	public abstract Object execute();
}
