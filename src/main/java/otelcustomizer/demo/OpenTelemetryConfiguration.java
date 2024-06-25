package otelcustomizer.demo;

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableOpenTelemetry
public class OpenTelemetryConfiguration {

  // via https://opentelemetry.io/docs/zero-code/java/spring-boot-starter/sdk-configuration/#programmatic-configuration
  // When this bean is enabled, then no traces will be exported at all
  @Bean
  public AutoConfigurationCustomizerProvider otelCustomizer() {
    return p ->
        p.addSpanProcessorCustomizer(
            (processor, config) ->
                new NullSpanProcessor()
        );
  }

}
