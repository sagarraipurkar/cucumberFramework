package testData;

public enum Api_urls {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String url;
	
	private Api_urls(String url) {
		this.url = url;
	}
	
	public String geturls() {
		return url;
	}

}
