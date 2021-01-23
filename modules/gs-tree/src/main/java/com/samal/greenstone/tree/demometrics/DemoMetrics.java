package com.samal.greenstone.tree.demometrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoMetrics {
    private final Counter demoCounter;
    private final AtomicInteger demoGauge;
    private final Random random = new Random();

    public DemoMetrics(MeterRegistry meterRegistry) {
        this.demoCounter = meterRegistry.counter("demo_counter");
        this.demoGauge = meterRegistry.gauge("demo_gauge", new AtomicInteger(0));
    }

    public void getRandomMetricsData() {
        demoGauge.set(getRandomNumberInRange(0, 100));
        demoCounter.increment();
    }

    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
