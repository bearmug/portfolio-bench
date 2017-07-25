package org.bearmug.qbit.services

import groovy.util.logging.Slf4j
import io.advantageous.qbit.annotation.PathVariable
import io.advantageous.qbit.annotation.RequestMapping
import org.bearmug.FibonacciCalc

@Slf4j
@RequestMapping('/fibonacci-qbit')
class QbitFibonacciService {

    @RequestMapping('/get/{0}')
    boolean get(@PathVariable int base) {
        new FibonacciCalc().fibonacci(base)
    }
}
