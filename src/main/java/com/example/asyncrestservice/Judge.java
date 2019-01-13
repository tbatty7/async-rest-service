package com.example.asyncrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Component
public class Judge {

    @Autowired
    BlockInterface repository;

    @Transactional
    public void evaluate() {
            System.out.println("processing request");
        Collection<Block> blocks = repository.findByValueIsNull();
        blocks.forEach(block -> {
            block.setValue("set");
            repository.save(block);
                });
    }
}
