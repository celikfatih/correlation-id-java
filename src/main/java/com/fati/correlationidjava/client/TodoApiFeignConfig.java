package com.fati.correlationidjava.client;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.fati.correlationidjava.filter.CorrelationIdFilter.CORRELATION_ID;
import static com.fati.correlationidjava.filter.CorrelationIdFilter.X_CORRELATION_ID;

@Configuration
@RequiredArgsConstructor
public class TodoApiFeignConfig {

    @Bean
    RequestInterceptor requestInterceptor() {
        return template -> {
            String correlationId = MDC.get(CORRELATION_ID);
            template.header(X_CORRELATION_ID, correlationId);
        };
    }
}
