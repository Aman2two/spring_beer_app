package com.example.beer_app.services.beer;

import com.example.beer_app.web.data.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
