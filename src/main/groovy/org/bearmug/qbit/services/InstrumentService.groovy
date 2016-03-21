package org.bearmug.qbit.services

import io.advantageous.qbit.annotation.RequestMapping


@RequestMapping('/instrument')
class InstrumentService {

    @RequestMapping('/find')
    boolean find(String instrument) {
        null
    }
}
