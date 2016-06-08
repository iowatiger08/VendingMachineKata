package com.tigersndragons.vendingmachine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
@RestController
@EnableAutoConfiguration
public class VendingController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Vending!";
    }

}
