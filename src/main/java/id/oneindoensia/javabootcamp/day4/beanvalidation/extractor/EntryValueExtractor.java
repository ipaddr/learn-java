package id.oneindoensia.javabootcamp.day4.beanvalidation.extractor;

import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Entry;
import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

public class EntryValueExtractor implements ValueExtractor<Entry<?, @ExtractedValue ?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "value", entry.getValue());
    }
}
