import java.util.ArrayList;


public class AvatarProfile {
	private String url;//AID of the avatar
	private int userID;
	private double lat;
	private double lon;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	private ArrayList<Integer> interests=new ArrayList<Integer>();
	private ArrayList<Double> interestsLevel=new ArrayList<Double>();
	public ArrayList<Double> getInterestsLevel() {
		return interestsLevel;
	}
	public void setInterestsLevel(ArrayList<Double> interestsLevel) {
		this.interestsLevel = interestsLevel;
	}
	private ArrayList<Integer> services=new ArrayList<Integer>();
	private Process goal=new Process();
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public ArrayList<Integer> getInterests() {
		return interests;
	}
	public void setInterests(ArrayList<Integer> interests) {
		this.interests = interests;
	}
	public ArrayList<Integer> getServices() {
		return services;
	}
	public void setServices(ArrayList<Integer> services) {
		this.services = services;
	}
	public Process getGoal() {
		return goal;
	}
	public void setGoal(Process goal) {
		this.goal = goal;
	}
	
	
	
	

}
