package com.example.asyncrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping(value = "/sand", method = RequestMethod.GET)
    public String addSand(){

        String sql = "INSERT INTO block( name, texture, pick_drops_block ) VALUES ( ?, ?, ? )";
        Object[] arguments = {"sand", "tan", false};
        jdbc.update(sql, arguments);
        return "submitted";
    }

    @RequestMapping(value = "/stone", method = RequestMethod.GET)
    public String addStone(){

        String sql = "INSERT INTO block( name, texture, pick_drops_block ) VALUES ( ?, ?, ? )";
        Object[] arguments = {"stone", "grey", true};
        jdbc.update(sql, arguments);
        return "submitted";
    }

    @RequestMapping(value = "/block", method = RequestMethod.POST)
    public String addBlock(@RequestBody BlockRequest request){

        Object[] arguments = {request.name, request.texture, request.dropsBlock};

        String sql = "INSERT INTO block( name, texture, pick_drops_block ) VALUES (?,?,?)";
        jdbc.update(sql, arguments);
        return "submitted";
    }
}
