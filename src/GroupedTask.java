import java.util.ArrayList;


public class GroupedTask {
	private ArrayList<Integer> atomicTasks=new ArrayList<Integer>();
	private String operation=new String();
	private int function;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFunction() {
		return function;
	}
	public void setFunction(int function) {
		this.function = function;
	}
	private ArrayList<Integer> functions=new ArrayList<Integer>();
	public ArrayList<Integer> getFunctions() {
		return functions;
	}
	public void setFunctions(ArrayList<Integer> functions) {
		this.functions = functions;
	}
	public ArrayList<Integer> getAtomicTasks() {
		return atomicTasks;
	}
	public void setAtomicTasks(ArrayList<Integer> atomicTasks) {
		this.atomicTasks = atomicTasks;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	

}
