package com.jonasesteves.algasensors.temperaturemonitoring.api.config.jpa;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TSIDToLongJPAAttributeConverter implements AttributeConverter<TSID, Long> {
    /*
    O JPA não sabe como converter internamente o TSID para um valor compatível com o banco de dados.
    Por isso a necessidade de criar um converter. (10.4)
    */

    @Override
    public Long convertToDatabaseColumn(TSID attribute) {
        return attribute.toLong();
    }

    @Override
    public TSID convertToEntityAttribute(Long dbData) {
        return TSID.from(dbData);
    }
}
