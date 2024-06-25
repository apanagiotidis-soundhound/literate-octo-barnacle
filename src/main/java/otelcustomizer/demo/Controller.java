package otelcustomizer.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/hello")
  ResponseEntity<Void> hello() {
      return ResponseEntity.ok().build();
  }

}
