import java.util.ArrayList;


public class Process 
{
	private ArrayList<Integer> atomictasks=new ArrayList<Integer>();
	private ArrayList<Integer> functions=new ArrayList<Integer>();
	public ArrayList<Integer> getFunctions() {
		return functions;
	}
	public void setFunctions(ArrayList<Integer> functions) {
		this.functions = functions;
	}
	private GroupedTask groupedTask=new GroupedTask();
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	private String operation=new String();
	public ArrayList<Integer> getAtomictasks() {
		return atomictasks;
	}
	public void setAtomictasks(ArrayList<Integer> atomictasks) {
		this.atomictasks = atomictasks;
	}
	public GroupedTask getGroupedTask() {
		return groupedTask;
	}
	public void setGroupedTask(GroupedTask groupedTask) {
		this.groupedTask = groupedTask;
	}
	

}
