package otelcustomizer.demo;

import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.NewSpan;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private final Tracer tracer;

  public Controller(Tracer tracer) {
    this.tracer = tracer;
  }

  @GetMapping("/hello")
  @NewSpan
  ResponseEntity<Void> hello() {
    try (
        final var ignoreBag = tracer.createBaggageInScope("someId", UUID.randomUUID().toString());
    ) {
      tracer.currentSpan().event("Test");

      return ResponseEntity.ok().build();
    }
  }

}
