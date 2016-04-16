package org.bearmug.qbit.services

import org.bearmug.qbit.CommonServiceTest
import spock.lang.Unroll

public class CalculatorServiceITest extends CommonServiceTest {

    @Unroll
    def '/calc/add/#a/#b adding "#a" and "#b" with output "#expectedRes"'() {

        when: "call /calc/add GET call done for #a and #b arguments"
        def response = client.get(path: "add/${a}/${b}")

        then: "correct result #expectedRes expected"
        with(response) {
            data == expectedRes
            status == 200
        }

        where:
        a              || b              || expectedRes
        1              || 1              || 2
        -1             || 1              || 0
        Long.MIN_VALUE || Long.MAX_VALUE || -1
    }
    
    @Unroll
    def '/calc/mult/#a/#b multiplication "#a" and "#b" with output "#expectedRes"'() {

        when: "call /calc/mult GET call done for #a and #b arguments"
        def response = client.get(path: "mult/${a}/${b}")

        then: "correct result #expectedRes expected"
        with(response) {
            data == expectedRes
            status == 200
        }

        where:
        a              || b              || expectedRes
        1              || 1              || 1
        -1             || 1              || -1
        Long.MIN_VALUE || 0              || 0
        33             || 100            || 3300
    }

    @Override
    String getServiceName() {
        return 'calc'
    }

    @Override
    Object getService() {
        return new CalculatorService()
    }
}
