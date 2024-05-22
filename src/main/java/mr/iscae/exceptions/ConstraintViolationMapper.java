package mr.iscae.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        final Map<String, String> constraintViolations = new HashMap<>();

        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            // Safely extract the property path
            String path = extractPropertyPath(cv.getPropertyPath().toString());
            constraintViolations.put(path, cv.getMessage());
        }

        return Response.status(Response.Status.PRECONDITION_FAILED)
                .entity(constraintViolations)
                .build();
    }

    
    private String extractPropertyPath(String propertyPath) {
        String[] parts = propertyPath.split("\\.");
        return parts.length > 2 ? parts[2] : propertyPath;
    }
}
