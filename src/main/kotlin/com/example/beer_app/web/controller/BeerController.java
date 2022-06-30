package com.example.beer_app.web.controller;

import com.example.beer_app.services.beer.BeerService;
import com.example.beer_app.web.data.BeerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private  BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    BeerDto getBeerById(@PathVariable("beerId")UUID beerId){
        return beerService.getBeerById(beerId);
    }
}
