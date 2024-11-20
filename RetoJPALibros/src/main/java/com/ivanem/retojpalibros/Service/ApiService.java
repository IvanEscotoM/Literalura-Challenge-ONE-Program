package com.ivanem.retojpalibros.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
//   public String obtenerDatos(String url) {
//       HttpClient client = HttpClient.newHttpClient();
//       HttpRequest request= HttpRequest.newBuilder().uri(URI.create("https://gutendex.com/books?search="+url)).build();
//       try {
//           System.out.println("https://gutendex.com//books?search="+url);
//           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//           System.out.println(response.body());
//           return response.body();
//       } catch (Exception e) {
//           System.out.println("Problemas para conectar a la API.");
//            return null;
//       }
//   }

    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        System.out.println(json);
        return json;
    }


}
