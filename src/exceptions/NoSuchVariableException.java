package exceptions;

public class NoSuchVariableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2095989362634315549L;
	String varname;
	public NoSuchVariableException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchVariableException(String arg0) {
		super(arg0);
		this.varname = arg0;
		// TODO Auto-generated constructor stub
	}

	public NoSuchVariableException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoSuchVariableException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.varname = arg0;
		// TODO Auto-generated constructor stub
	}

	public NoSuchVariableException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		this.varname = arg0;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "No such variable exist , varname(" + this.varname + ")";
	}
}
