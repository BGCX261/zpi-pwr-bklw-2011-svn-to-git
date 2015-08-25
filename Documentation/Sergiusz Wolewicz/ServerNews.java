package zpi.interfejs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class ServerNews {

public ArrayList<News> newsList;
	
	public void GetEventsFromServer(int id) throws ClientProtocolException, IOException {
		if (id == 0)
			id = -1;
		HttpClient client = new DefaultHttpClient();
		String connectionString = "http://156.17.130.96/admin/news/getnews/" + Integer.toString(id);
		HttpPost post = new HttpPost(connectionString);
		HttpResponse response = client.execute(post);
		try {
			newsList = new ArrayList<News>();
			InputStream in = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String s = br.readLine();
			if (s.equals("Jest")) {
				while( (s = br.readLine()) != null) {
					int nid = Integer.parseInt(s);
					String title = br.readLine(), discription = br.readLine(), logo = br.readLine();
					News n = new News(nid, title, discription, logo);
					newsList.add(n);
				}
			}
		}
		catch (Exception e) {
			
		}
	}
	
	public ArrayList<News> GetNews() {
		return newsList;
	}
	
}
