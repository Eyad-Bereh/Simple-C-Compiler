package exceptions;

public class VariableAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -448345745513109498L;

	private String varname;
	
	public VariableAlreadyExistException() {
		// TODO Auto-generated constructor stub
	}

	public VariableAlreadyExistException(String varname) {
		super(varname);
		this.varname = varname;
		// TODO Auto-generated constructor stub
	}

	public VariableAlreadyExistException(Throwable error) {
		super(error);
		// TODO Auto-generated constructor stub
	}

	public VariableAlreadyExistException(String varname, Throwable err) {
		super(varname, err);
		this.varname = varname;
		// TODO Auto-generated constructor stub
	}

	public VariableAlreadyExistException(String varname, Throwable err, boolean arg2, boolean arg3) {
		super(varname, err, arg2, arg3);
		this.varname = varname;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Variable already exist , varname(" + this.varname + ")";
	}
}
