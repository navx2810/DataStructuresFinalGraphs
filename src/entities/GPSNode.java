package entities;

public class GPSNode extends Node {

	public double longitude, latitude, height;
	public String locationName;

	public GPSNode(int id, String locationName, double longitude, double latitude, double height) {
		super(id);
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		this.locationName = locationName;
	}


	

}
