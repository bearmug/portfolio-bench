package org.bearmug.qbit


interface DataProvider {
    boolean exists(String instrument)
    InstrumentProfile find(String instrument)
}