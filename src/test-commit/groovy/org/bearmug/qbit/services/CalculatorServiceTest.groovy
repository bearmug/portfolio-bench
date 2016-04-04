package org.bearmug.qbit.services

import spock.lang.Specification
import spock.lang.Unroll;

class CalculatorServiceTest extends Specification {

    @Unroll
    def '/calc/add/#a/#b adding "#a" and "#b" with output "#expectedRes"'() {
        given: "CalculatorService initialized"
        CalculatorService service = new CalculatorService()

        when: "/calc/add GET handler called"
        long res = service.add(a, b)

        then:
        expectedRes == res

        where:
        a              || b              || expectedRes
        1              || 1              || 2
        -1             || 1              || 0
        Long.MIN_VALUE || Long.MAX_VALUE || -1
    }
}
