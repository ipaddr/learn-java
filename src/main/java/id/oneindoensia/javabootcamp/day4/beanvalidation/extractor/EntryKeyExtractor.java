package id.oneindoensia.javabootcamp.day4.beanvalidation.extractor;

import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryKeyExtractor implements ValueExtractor<Entry<@ExtractedValue ?, ?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "key", entry.getKey());
    }
}
