package com.example.asyncrestservice;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SandboxTests {

    private ArrayList<BlockRequest> blockRequests;

    @Before
    public void setUp() {
        BlockRequest blockRequest1 = new BlockRequest("name1", "texture1", true);
        BlockRequest blockRequest2 = new BlockRequest("name1", "texture2", true);
        BlockRequest blockRequest3 = new BlockRequest("name2", "texture3", true);
        BlockRequest blockRequest4 = new BlockRequest("name3", "texture4", true);
        BlockRequest blockRequest5 = new BlockRequest("name4", "texture5", true);
        BlockRequest blockRequest6 = new BlockRequest("name4", "texture6", true);
        BlockRequest blockRequest7 = new BlockRequest("name5", "texture7", true);

        blockRequests = new ArrayList<>();
        blockRequests.add(blockRequest1);
        blockRequests.add(blockRequest2);
        blockRequests.add(blockRequest3);
        blockRequests.add(blockRequest4);
        blockRequests.add(blockRequest5);
        blockRequests.add(blockRequest6);
        blockRequests.add(blockRequest7);
    }

    @Test
    public void mapReduceValues() {
        HashMap<String, List<String>> blockMap = new HashMap<>();
        for (BlockRequest request : blockRequests) {
            if (blockMap.containsKey(request.name)) {
                List list = blockMap.get(request.name);
                list.add(request.texture);
            } else {
                ArrayList<String> textures = new ArrayList<>();
                textures.add(request.texture);
                blockMap.put(request.name, textures);
            }
        }
        assertEquals("texture1", blockMap.get("name1").get(0));
    }

    @Test
    public void listOfArrays() {
        ArrayList<String[]> tuples = new ArrayList<>();
        for (BlockRequest request : blockRequests) {
            tuples.add(new String[]{request.name, request.texture});
        }

        String result = "";
        for (String[] tuple : tuples) {
            if (tuple[0] == "name5"){
                result = tuple[1];
            }
        }
        assertEquals(result, "texture7");
    }
}
