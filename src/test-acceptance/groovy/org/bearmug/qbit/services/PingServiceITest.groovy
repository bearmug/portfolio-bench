package org.bearmug.qbit.services

import org.bearmug.qbit.CommonServiceTest
import spock.lang.Unroll

class PingServiceITest extends CommonServiceTest {

    @Unroll
    def '/simple/ping should always return true'() {

        when: "call /ping GET call done"
        def response = client.get(path: "ping")

        then: "correct result returned"
        with(response) {
            data == true
            status == 200
        }
    }

    @Override
    String getServiceName() {
        return 'simple'
    }

    @Override
    Object getService() {
        return new PingService()
    }
}
