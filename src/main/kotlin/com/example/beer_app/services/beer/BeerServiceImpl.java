package com.example.beer_app.services.beer;

import com.example.beer_app.services.beer.BeerService;
import com.example.beer_app.web.data.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().beerId(beerId).beerName("").beerType("strong").build();
    }

    @Override
    public BeerDto saveBeerDto(BeerDto beerDto) {
        return BeerDto.builder().beerId(beerDto.getBeerId()).beerType(beerDto.getBeerType()).beerName(beerDto.getBeerName()).build();
    }
}
