package com.challenge.util;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PiApi {
    private static final String BASE_URL = "https://api.pi.delivery/v1/pi?";

    private PiApi() {
    }

    public static String getDataFromApi(long start, int numberOfDigits) {
        var url = BASE_URL + "start=" + start + "&numberOfDigits=" + numberOfDigits;
        try {
            var request = HttpRequest
                    .newBuilder(new URI(url))
                    .GET()
                    .build();

            var response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();

            var json = new JSONObject(response);
            return json.get("content").toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static String getPiPage(long n) {
        try {
            return requestPi(n);
        } catch (Exception e) {
            System.out.printf("Error happend :: %s\n", e.getMessage());
        }
        return "";
    }

    private static String requestPi(long n) throws URISyntaxException, IOException, InterruptedException {
        long page = 1000 * (n - 1);
        final var url = String.format("https://api.pi.delivery/v1/pi?start=%s&numberOfDigits=1000", page);
        var request = HttpRequest
                .newBuilder(new URI(url))
                .GET()
                .build();

        var response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();

        var json = new JSONObject(response);
        return json.get("content").toString();
    }
}