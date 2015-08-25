package zpi.interfejs;

import java.io.*;
import java.util.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class ServerEvents {

	public ArrayList<Event> eventsList;
	
	public void GetEventsFromServer(int id) throws ClientProtocolException, IOException {
		if (id == 0)
			id = -1;
		HttpClient client = new DefaultHttpClient();
		String connectionString = "http://156.17.130.96/admin/events/getevents/" + Integer.toString(id);
		HttpPost post = new HttpPost(connectionString);
		HttpResponse response = client.execute(post);
		try {
			eventsList = new ArrayList<Event>();
			InputStream in = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String s = br.readLine();
			if (s.equals("Jest")) {
				while( (s = br.readLine()) != null) {
					int eid = Integer.parseInt(s);
					String title = br.readLine(), discription = br.readLine(), logo = br.readLine(),
									video = br.readLine(), audio = br.readLine();
					Event e = new Event(eid, title, discription, logo, video, audio);
					eventsList.add(e);
				}
			}
		}
		catch (Exception e) {
			
		}
	}
	
	public ArrayList<Event> GetEvents() {
		return eventsList;
	}
	
}
