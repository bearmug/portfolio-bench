package org.bearmug.qbit.services

import spock.lang.Specification

class SimpleServiceTest extends Specification {

    def '/simple/ping should always return true'() {
        given:
            def PingService service = new PingService()

        when:
            def res = service.ping()

        then:
            res
    }
}
