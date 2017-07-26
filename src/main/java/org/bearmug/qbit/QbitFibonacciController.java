package org.bearmug.qbit;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import org.bearmug.FibonacciCalc;

@RequestMapping("/fibonacci-qbit")
class QbitFibonacciController {

    @RequestMapping("/get/{0}")
    int get(@PathVariable int base) {
        return new FibonacciCalc().fibonacci(base);
    }
}
