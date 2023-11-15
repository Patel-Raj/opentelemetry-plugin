package io.jenkins.plugins.opentelemetry.job.log.util;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class LineIteratorInputStreamTest {

    @Test
    public void skipTest_PositiveCase() throws IOException {
        // Arrange
        Tracer tracer = spy(Tracer.class);
        Span span = spy(Span.class);
        LineIterator.LineBytesToLineNumberConverter lineBytesToLineNumberConverter = spy(LineIterator.LineBytesToLineNumberConverter.class);
        LineIterator lines = spy(LineIterator.class);
        LineIteratorInputStream lineIteratorInputStream = new LineIteratorInputStream(lines, lineBytesToLineNumberConverter, tracer);
        when(lineBytesToLineNumberConverter.getLogLineFromLogBytes(anyLong())).thenReturn(10L);

        // Act
        long actualSkipBytes = lineIteratorInputStream.skip(5);

        // Assert
        assertEquals(5, actualSkipBytes);
    }
}