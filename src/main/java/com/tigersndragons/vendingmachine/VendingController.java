package com.tigersndragons.vendingmachine;

import com.tigersndragons.vendingmachine.DataTransfers.VendingRequest;
import com.tigersndragons.vendingmachine.DataTransfers.VendingResponse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tdillon-hansen
 */
@RestController
@EnableAutoConfiguration
public class VendingController {

    @RequestMapping("/")
    @ResponseBody
    VendingResponse Post(VendingRequest request) {
        throw new NotImplementedException();
    }


}
