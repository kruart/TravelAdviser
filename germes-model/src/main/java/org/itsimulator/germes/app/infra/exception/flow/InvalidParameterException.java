package org.itsimulator.germes.app.infra.exception.flow;

import org.itsimulator.germes.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * @author admin
 *
 */
public class InvalidParameterException extends FlowException {

    private static final long serialVersionUID = 4990959228756992926L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
