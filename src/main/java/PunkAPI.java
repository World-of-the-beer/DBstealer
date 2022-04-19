import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bson.Document;


import java.io.IOException;

public class PunkAPI {

    public static void main(String[] args) throws IOException {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("WoB");
        MongoCollection collection = database.getCollection("Beers");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();



        int i =1;

        String[] result = {};


        while (result.length != 1) {
            String urlpage = String.format("https://api.punkapi.com/v2/beers?page=%d&per_page=80", i);


            System.out.println(urlpage);
            HttpGet reqest = new HttpGet(urlpage);
            i++;
            CloseableHttpResponse response = httpClient.execute(reqest);

            HttpEntity entity = response.getEntity();

            //ответ включает в себя до 80 объектов. Дробим и костылим кавычки.
            result = EntityUtils.toString(entity).split("(?=\"id\")");
            for (String s :
                    result) {
                if(s.length()>3) {
                s="{"+s.substring(0,s.length()-2);
                if (s.charAt(s.length()-1) != '}') s = s + "}";
                Beer beer = gson.fromJson(s, Beer.class);

                System.out.println(beer);
                Document doc = Document.parse(s);
                collection.insertOne(doc);

               }
                response.close();

            }
        }
    }
}
