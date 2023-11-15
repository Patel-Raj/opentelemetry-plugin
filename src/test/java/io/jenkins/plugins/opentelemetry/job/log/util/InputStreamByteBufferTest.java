package io.jenkins.plugins.opentelemetry.job.log.util;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

public class InputStreamByteBufferTest {

    @Test
    public void testLength_PositiveCase() {
        // Arrange
        Tracer tracer = spy(Tracer.class);
        Span span = spy(Span.class);
        InputStream inputStream = spy(InputStream.class);
        InputStreamByteBuffer byteBuffer = new InputStreamByteBuffer(inputStream, tracer);

        // Act
        long actualResult = byteBuffer.length();

        // Assert
        assertEquals(153600, actualResult);
    }
}