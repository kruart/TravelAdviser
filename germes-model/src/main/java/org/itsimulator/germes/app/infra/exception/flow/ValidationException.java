package org.itsimulator.germes.app.infra.exception.flow;

import org.itsimulator.germes.app.infra.exception.FlowException;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@link ValidationException} is raised when attribute values of the
 * object model violates business rules or restrictions
 * @author Morenets
 *
 */
public class ValidationException extends FlowException {
    private static final long serialVersionUID = 6858621613562789296L;

    public <T> ValidationException(String message, Set<ConstraintViolation<T>> constraints) {
        super(message + ":" + constraints.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
    }
}
