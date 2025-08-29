package com.jonasesteves.algasensors.temperaturemonitoring.api.config.jackson;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TSIDJacksonConfig {
    /*
    Classe necessária para serializar o TSID no formato de hash (mais amigável ao usuário)
    ao invés de serializar no formato do objeto TSID. (10.2 e 10.3)
    (Fórum e suporte da 10.3 - String serializer padrão do jackson Solucionada )
    */

    @Bean
    public Module tsidModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(TSID.class, ToStringSerializer.instance);
        return module;
    }
}
