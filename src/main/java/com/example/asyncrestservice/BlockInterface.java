package com.example.asyncrestservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BlockInterface extends CrudRepository<Block,Long> {
    Collection<Block> findByValueIsNull();
    Collection<Block> findAll();
}
