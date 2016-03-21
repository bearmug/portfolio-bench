package org.bearmug.qbit.services

import com.jimmoores.quandl.QuandlSession
import com.jimmoores.quandl.TabularResult
import io.advantageous.qbit.annotation.RequestMapping


@RequestMapping('/instrument')
class InstrumentService {

    @RequestMapping('/exists')
    boolean exists(String instrument) {
        QuandlSession session = QuandlSession.create();
        TabularResult tabularResult = session.getDataSet(
                DataSetRequest.Builder.of("WIKI/${instrument}").build());
        System.out.println(tabularResult.toPrettyPrintedString());
    }

    @RequestMapping('/find')
    boolean find(String instrument, String format) {
        QuandlSession session = QuandlSession.create();
        TabularResult tabularResult = session.getDataSet(
                DataSetRequest.Builder.of("${format}/${instrument}").build());
        System.out.println(tabularResult.toPrettyPrintedString());
    }
}
