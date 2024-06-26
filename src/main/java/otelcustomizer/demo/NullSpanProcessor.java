package otelcustomizer.demo;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullSpanProcessor implements SpanProcessor {

  @Override
  public void onStart(Context context, ReadWriteSpan readWriteSpan) {
    log.info("NullSpanProcessor.onStart");
  }

  @Override
  public boolean isStartRequired() {
    return true;
  }

  @Override
  public void onEnd(ReadableSpan readableSpan) {
    log.info("NullSpanProcessor.onEnd");
  }

  @Override
  public boolean isEndRequired() {
    return true;
  }

}
