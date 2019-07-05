package amar.restWebService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by amarendra on 10/09/17.
 */
public class RestWebServiceTest {

    public static void main(String[] args) throws IOException {
        String uri =
                "http://jsonplaceholder.typicode.com/posts";
        URL url = new URL(uri);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //connection.setRequestProperty("Accept", MediaType.APPLICATION_JSON);
        InputStream inputStream = connection.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Object readValue = objectMapper.readValue(inputStream, Object.class);
        //System.out.println(readValue);
        readObject(readValue);

    }

    private static void readObject(final Object object) {
        if (object instanceof List) {
            List list = (List) object;
            list.forEach(o -> {
                readObject(o);
            });
        } else if (object instanceof Map) {
            Map map = (Map) object;
            map.forEach((k, v) -> {
                System.out.println("Key -> " + k + " || Value -> " + v);
            });
            System.out.println("-------------");
        } else {
            throw new RuntimeException("Neither a map nor a list");
        }
    }
}
