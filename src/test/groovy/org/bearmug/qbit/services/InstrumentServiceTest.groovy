package org.bearmug.qbit.services

import spock.lang.Specification

class InstrumentServiceTest extends Specification {

    def '/instrument/find return true if instrument available'() {
        given:
        def InstrumentService service = new InstrumentService()

        when:
        def res = service.find 'VALID_INSTRUMENT'

        then:
        res
    }

    def '/instrument/find return false if instrument empty/null/unavailable'() {
        given:
        def InstrumentService service = new InstrumentService()

        when:
        def res = service.find instrument

        then:
        res == expectedRes

        where:
        instrument              || expectedRes
        ''                      || false
        null                    || false
        'INVALID_$_INSTRUMENT ' || false

    }
}
