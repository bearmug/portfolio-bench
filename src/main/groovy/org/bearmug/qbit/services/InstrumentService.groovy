package org.bearmug.qbit.services

import io.advantageous.qbit.annotation.PathVariable
import io.advantageous.qbit.annotation.RequestMapping
import org.bearmug.qbit.CacheProvider
import org.bearmug.qbit.DataProvider
import org.bearmug.qbit.InstrumentProfile

@RequestMapping('/instrument')
class InstrumentService {

    DataProvider dataProvider
    CacheProvider cacheProvider

    @RequestMapping('/exists/{0}')
    boolean exists(@PathVariable String instrument) {

        // sync part
        if (cacheProvider.exists(instrument)) {
            return true
        }

        // convert to async
        InstrumentProfile profile = dataProvider.find instrument
        cacheProvider.addInstrument(instrument, profile)
        profile.exists
    }

    @RequestMapping('/find/{0}/{1}')
    String find(@PathVariable String instrument, @PathVariable String format) {

        // sync part
        if (cacheProvider.getInstrumentProfile(instrument)){
            return cacheProvider.getInstrumentProfile(instrument).prettyString
        }

        // conert to async
        InstrumentProfile profile = dataProvider.find instrument
        cacheProvider.addInstrument(instrument, profile)
        profile.prettyString
    }
}
