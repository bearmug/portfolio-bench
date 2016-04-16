package org.bearmug.qbit.services

import groovy.util.logging.Slf4j
import io.advantageous.qbit.annotation.PathVariable
import io.advantageous.qbit.annotation.RequestMapping

@Slf4j
@RequestMapping('/calc')
class CalculatorService {

    @RequestMapping('/add/{0}/{1}')
    long add(@PathVariable long a, @PathVariable long b) {
        a + b
    }
    
    @RequestMapping('/mult/{0}/{1}')
    long mult(@PathVariable long a, @PathVariable long b) {
        a * b
    }
}


