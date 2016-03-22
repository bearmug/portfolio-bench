package org.bearmug.qbit


interface CacheProvider {

    InstrumentProfile getInstrumentProfile(String instrument)
    boolean exists(String instrument)
    boolean addInstrument(String instrument, InstrumentProfile profile)
}
