package main;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HandlerPiApi {
    private static final String BASE_URL = "https://api.pi.delivery/v1/pi?";
    private HandlerPiApi() {
    }

    public static String getDataFromApi(long start, int numberOfDigits) {
        var url = BASE_URL + "start=" + start + "&numberOfDigits=" + numberOfDigits;
        for(int actualTry=0;;actualTry++) {
            try {
                var request = HttpRequest
                        .newBuilder(new URI(url))
                        .GET()
                        .build();

                return HttpClient.newBuilder()
                        .build()
                        .send(request, HttpResponse.BodyHandlers.ofString())
                        .body().split("\"")[3];
            } catch (URISyntaxException e) {
                if (actualTry < 3) {
                    continue;
                }
                e.printStackTrace();
            } catch (IOException | InterruptedException e) {
                if (actualTry < 3) {
                    continue;
                }
                throw new RuntimeException(e);
            }
        }
    }
}
