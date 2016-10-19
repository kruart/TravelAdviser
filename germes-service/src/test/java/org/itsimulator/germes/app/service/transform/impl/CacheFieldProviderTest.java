package org.itsimulator.germes.app.service.transform.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 *
 * @author admin
 *
 */
public class CacheFieldProviderTest {
    private FieldProvider provider;

    @Before
    public void setup() {
        provider = new CacheFieldProvider();
    }

    @Test
    public void testGetFieldNamesSuccess() {
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertTrue(fields.contains("value"));
    }

    @Test
    public void testGetFieldNamesCachedSuccess() {
        List<String> fields = provider.getFieldNames(Source.class, Destination.class);
        List<String> fields2 = provider.getFieldNames(Source.class, Destination.class);
        assertFalse(fields.isEmpty());
        assertEquals(fields, fields2);
    }

}

class Source {
    int value;
}

class Destination {
    int value;
}