package org.bearmug.qbit.services

import spock.lang.Specification

class PingServiceTest extends Specification {

    def '/simple/ping should always return true'() {
        given: "PingService initialized"
            def PingService service = new PingService()

        when: "/simple/ping called"
            def res = service.ping()

        then: "success result highlighted"
            res
    }
}
