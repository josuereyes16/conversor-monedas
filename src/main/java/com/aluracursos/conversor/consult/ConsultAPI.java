package com.aluracursos.conversor.consult;

import com.aluracursos.conversor.model.Money;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultAPI {
    public Money convert(String baseCurrency, String targetCurrency, Double amount) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ed7112545f53b4cc5c2beb39/latest/" + baseCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Money money = new Gson().fromJson(response.body(), Money.class);
            double rate = money.getConversionRate(targetCurrency);
            return new Money(baseCurrency, targetCurrency, amount, amount * rate);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
