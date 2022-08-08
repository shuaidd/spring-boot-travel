package com.travel.web.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 新通教育
 *
 * @author ddshuai
 * date 2022-07-29 11:05
 **/
@RestController
//@RequestMapping("doc/test")
public class DocController {

    @RequestMapping(value = "gen",consumes = {"application/json"} ,produces = {"application/json"},method = RequestMethod.GET)
    public Map<String,String> gen(@RequestParam String mode) {
        return new HashMap<>();
    }
}
