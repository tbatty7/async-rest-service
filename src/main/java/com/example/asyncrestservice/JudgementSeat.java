package com.example.asyncrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class JudgementSeat {

    private final Judge judge;

    @Autowired
    public JudgementSeat(Judge judge) {
        this.judge = judge;
    }

    @Scheduled(fixedDelay = 10000)
    public void doItLater(){
        System.out.println("tried to evaluate");
        judge.evaluate();
    }

}
