package nodes;

public class variable {
	private static int VM_CURRENT_ADDRESS = 0x00400;
	private static int VM_NEXT_AVAILABLE_ADDRESS = 0X00400;
	
	private Object value;
	private String type;
	private int address;
	private int size;
	
	public variable(String type, int size) {
		this.type = type;
		this.value = null;
		this.size = size;
		VM_CURRENT_ADDRESS = VM_NEXT_AVAILABLE_ADDRESS;
		this.address = VM_CURRENT_ADDRESS;
		VM_NEXT_AVAILABLE_ADDRESS += this.size;
	}
	
	public variable(String type, int size, int address) {
		this.type = type;
		this.value = null;
		this.size = size;
		this.address = address;
	}
	
	public variable(String type, Object value, int size) {
		this.type = type;
		this.value = value;
		this.size = size;
		VM_CURRENT_ADDRESS = VM_NEXT_AVAILABLE_ADDRESS;
		this.address = VM_CURRENT_ADDRESS;
		VM_NEXT_AVAILABLE_ADDRESS += this.size;
	}
	
	public variable(String type, Object value, int size, int address) {
		this.type = type;
		this.value = value;
		this.size = size;
		this.address = address;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getAddress() {
		return this.address;
	}
	
	public void setAddress(int address) {
		
	}
	
	public static int getCurrentVMAddress() {
		return VM_CURRENT_ADDRESS;
	}
	
	public static int getNextAvailableVMAddress() {
		return VM_NEXT_AVAILABLE_ADDRESS;
	}
	
	@Override
	public String toString() {
		String result = "(type: " + this.type + ", ";
		result += "value: " + this.value + ", ";
		result += "size: " + this.size + ", ";
		result += "address: " + this.address;
		result += ")";
		return result;
	}
}
