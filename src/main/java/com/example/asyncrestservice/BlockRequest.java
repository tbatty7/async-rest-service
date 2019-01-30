package com.example.asyncrestservice;

public class BlockRequest {
    public String name;
    public String texture;
    public boolean dropsBlock;

    public BlockRequest() {
    }

    public BlockRequest(String name, String texture, boolean dropsBlock) {
        this.name = name;
        this.texture = texture;
        this.dropsBlock = dropsBlock;
    }
}
