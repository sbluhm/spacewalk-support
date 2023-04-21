package org.stringtree.mock;

public class MockAction {
    
	public Object destination;
	public String message;
	public Object[] arguments;

	public MockAction(Object destination, String message, Object[] arguments) {
		this.destination = destination;
		this.message = message;
		this.arguments = arguments;
	}

	public MockAction(Object destination, String message) {
		this(destination, message, null);
	}
	
	public String toString() {
		return "calling '" + message + "' on object '" + destination + "' with args (" + expandArgs() + ")";  
	}

	public String expandArgs() {
		if (arguments == null) return "";
		int last = arguments.length-1;
		StringBuffer ret = new StringBuffer();
		
		for (int i = 0; i < last; ++i) {
			ret.append(arguments[i]);
			ret.append(", ");
		}
		ret.append(arguments[last]);
		
		return ret.toString();
	}
    
    public String asCall() {
        return message + "(" + expandArgs() + ")";
    }
}
