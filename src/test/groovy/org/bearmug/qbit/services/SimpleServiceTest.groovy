package org.bearmug.qbit.services

import spock.lang.Specification

class SimpleServiceTest extends Specification {

    def '/simple/find should always return true'() {
        given:
            def SimpleService service = new SimpleService()

        when:
            def res = service.findCorrelation()

        then:
            res
    }
}
