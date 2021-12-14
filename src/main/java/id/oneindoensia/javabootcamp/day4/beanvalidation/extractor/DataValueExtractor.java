package id.oneindoensia.javabootcamp.day4.beanvalidation.extractor;

import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {
    @Override
    public void extractValues(Data<?> data, ValueReceiver valueReceiver) {
        valueReceiver.value(null, data.getData());
    }
}
