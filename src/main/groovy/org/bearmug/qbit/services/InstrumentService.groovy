package org.bearmug.qbit.services

import com.jimmoores.quandl.DataSetRequest
import com.jimmoores.quandl.QuandlSession
import com.jimmoores.quandl.SearchRequest
import com.jimmoores.quandl.SearchResult
import com.jimmoores.quandl.TabularResult
import io.advantageous.qbit.annotation.PathVariable
import io.advantageous.qbit.annotation.RequestMapping



@RequestMapping('/instrument')
class InstrumentService {

    final QuandlSession session = QuandlSession.create();

    final Map<String, Boolean> instruments = [:]

    @RequestMapping('/exists/{0}')
    boolean exists(@PathVariable String instrument) {

        if (instruments.$instrument != null) {
            return instruments.$instrument
        }

        SearchResult searchResult = session.search(
                SearchRequest.Builder.newInstance().withQuery(instrument).build());
        def res = searchResult.getTotalDocuments() > 0
        instruments.$instrument = res

        res
    }

    @RequestMapping('/find/{0}/{1}')
    String find(@PathVariable String instrument, @PathVariable String format) {

        TabularResult tabularResult = session.getDataSet(
                DataSetRequest.Builder.of("${format}/${instrument}").build());
        tabularResult.toPrettyPrintedString();
    }
}
