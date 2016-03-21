package org.bearmug.qbit.services

import spock.lang.Specification
import spock.lang.Unroll

class InstrumentServiceTest extends Specification {

    def '/instrument/find return true if instrument available'() {
        given:
        def InstrumentService service = new InstrumentService()

        when:
        def res = service.find 'VALID_INSTRUMENT'

        then:
        res
    }

    @Unroll()
    def '/instrument/find return false if instrument is "#instrument"'() {
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
