package zpi.interfejs;

public class Event {

	int id;
	 String title, discription, logo, video, audio;
	public Event(int id, String title, String discription, String logo, String video, String audio) {
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.logo = logo;
		this.video = video;
		this.audio = audio;
	}
	
	public String ToString() {
		return id + " " + title + " " + discription + " " + logo + " " + video + " " + audio;
	}
}
