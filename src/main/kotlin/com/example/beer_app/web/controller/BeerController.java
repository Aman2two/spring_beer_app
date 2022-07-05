package com.example.beer_app.web.controller;

import com.example.beer_app.services.beer.BeerService;
import com.example.beer_app.web.data.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;


@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private  BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity saveBeer(@Valid  @RequestBody  BeerDto beerDto){
        BeerDto saveBeerDto = beerService.saveBeerDto(beerDto);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("location",saveBeerDto.getBeerId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List> handleConstraintViolation(MethodArgumentNotValidException exception){
        List<String> errorsList= new ArrayList<>();
        BindingResult result = exception.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            errorsList.add(fieldError.getField()+" "+fieldError.getDefaultMessage());
        });
        Map map=new HashMap();
        map.put("Error",errorsList);
        return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
    }
}
