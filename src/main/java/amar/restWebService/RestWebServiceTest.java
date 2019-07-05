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

    public static void main(final String[] args) throws IOException {
        final String uri =
                "http://jsonplaceholder.typicode.com/posts";
        final URL url = new URL(uri);
        final HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        //connection.setRequestProperty("Accept", MediaType.APPLICATION_JSON);
        final InputStream inputStream = connection.getInputStream();
        final ObjectMapper objectMapper = new ObjectMapper();
        final Object readValue = objectMapper.readValue(inputStream, Object.class);
        //System.out.println(readValue);
        readObject(readValue);

    }

    private static void readObject(final Object object) {
        if (object instanceof List) {
            final List list = (List) object;
            list.forEach(o -> {
                readObject(o);
            });
        } else if (object instanceof Map) {
            final Map map = (Map) object;
            map.forEach((k, v) -> {
                System.out.println("Key -> " + k + " || Value -> " + v);
            });
            System.out.println("-------------");
        } else {
            throw new RuntimeException("Neither a map nor a list");
        }
    }
}
