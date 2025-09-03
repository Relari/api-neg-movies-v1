package pe.com.relari.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.com.relari.config.ErrorProperties;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlerTest {

    @Mock
    ErrorProperties errorProperties;

    @InjectMocks
    ExceptionHandler exceptionHandler;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToResponse() {

        Mockito.when(errorProperties.defaultMessage()).thenReturn("Default error message");
        Mockito.when(errorProperties.status()).thenReturn(500);

        var response = exceptionHandler.toResponse(new ApiException("Test exception message"));

        assertNotNull(response);
        assertEquals(500, response.getStatus());
        assertNotNull(response.getEntity());
        assertTrue(response.getEntity().toString().contains("Default error message"));

    }

    @Test
    void testToResponseWithThrowableMessage() {

        Mockito.when(errorProperties.defaultMessage()).thenReturn("Default error message");
        Mockito.when(errorProperties.status()).thenReturn(500);

        var response = exceptionHandler.toResponse(new ApiException("Test exception message", new Throwable("Cause message")) );

        assertNotNull(response);
        assertEquals(500, response.getStatus());
        assertNotNull(response.getEntity());
        assertTrue(response.getEntity().toString().contains("Default error message"));

    }
}