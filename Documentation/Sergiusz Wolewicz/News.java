package zpi.interfejs;

public class News {

	int id;
	String title, discription, logo;
	
	public News(int id, String title, String discription, String logo) {
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.logo = logo;
	}
	
	public String ToString() {
		return id + " " + title + " " + discription + " " + logo;
	}
}
