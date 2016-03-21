package org.bearmug.qbit.services

import groovy.util.logging.Slf4j
import io.advantageous.qbit.annotation.RequestMapping

@Slf4j
@RequestMapping('/simple')
class PingService {

    @RequestMapping('/ping')
    boolean ping() {
        true
    }
}
