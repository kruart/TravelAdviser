package org.itsimulator.germes.app.infra.util;

import org.itsimulator.germes.app.infra.exception.flow.InvalidParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Verifies functionality of {@link Checks} class
 * @author admin
 *
 */
public class ChecksTest {

    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test");

            assertTrue(false);
        } catch (Exception e) {
            assertSame(e.getClass(), InvalidParameterException.class);
            assertEquals(e.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test");

        assertTrue(true);
    }
}