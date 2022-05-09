package com.group7.creditsservice.controller;

import com.group7.creditsservice.entity.MovementCreditCard;
import com.group7.creditsservice.service.IMovementCreditCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit_cards/movement")
@AllArgsConstructor
@Slf4j
public class MovementCreditCardController {

    private IMovementCreditCardService service;

    @GetMapping
    public Flux<MovementCreditCard> getAllMovements(){
        return service.getAll();
    }

    @GetMapping("/product/{credit}")
    public Flux<MovementCreditCard> getAllMovementsByCredit(@PathVariable String credit){
        return service.getAllMovementsByCredit(credit);
    }

    @GetMapping("/product/{credit}/state/{year}/{month}")
    public Mono<Double> getStateByCreditPerMonthAndYear(@PathVariable String credit, @PathVariable int year, @PathVariable int month){
        return service.getStateByCreditPerMonthAndYear(credit, year, month);
    }

    @GetMapping("{id}")
    public Mono<MovementCreditCard> getMovement(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovementCreditCard> saveMovement(@RequestBody MovementCreditCard movementRequest){
        return service.save(movementRequest);
    }

    @PutMapping("{id}")
    public Mono<MovementCreditCard> updateMovement(@PathVariable String id,
                                                 @RequestBody MovementCreditCard movementRequest){
        return service.update(id, movementRequest);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteMovement(@PathVariable String id){
        return service.delete(id);
    }

    @DeleteMapping
    public Mono<Void> deleteAllMovements(){
        return service.deleteAll();
    }

}
