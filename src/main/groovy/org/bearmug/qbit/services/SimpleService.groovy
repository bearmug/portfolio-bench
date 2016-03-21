package org.bearmug.qbit.services

import groovy.util.logging.Slf4j
import io.advantageous.qbit.annotation.RequestMapping

@Slf4j
@RequestMapping('/simple')
class SimpleService {

    @RequestMapping('/find')
    boolean findCorrelation() {
        log.debug '/simple/find path call done'
        true
    }
}
