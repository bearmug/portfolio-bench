package org.bearmug

import spock.lang.Specification
import spock.lang.Unroll

class ImportantInstanceTest extends Specification {

    @Unroll
    def 'fibonacci number #num equals to #expectedRes'() {
        given: "ImportantInstance initialized"
        ImportantInstance instance = new ImportantInstance()

        when: "fibonacci calculation called"
        long res = instance.fibonacci(num)

        then:
        expectedRes == res

        where:
        num || expectedRes
        1   || 1
        2   || 1
        3   || 2
        4   || 3
        5   || 5
        6   || 8
        7   || 13
        8   || 21
    }
}
