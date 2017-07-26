package org.bearmug.boot;

import org.bearmug.FibonacciCalc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fibonacci-boot/")
public class BootFibonacciController {

    @RequestMapping(value = "get/{base}", method = RequestMethod.GET)
    int get(@PathVariable("base") int base) {
        return new FibonacciCalc().fibonacci(base);
    }
}
