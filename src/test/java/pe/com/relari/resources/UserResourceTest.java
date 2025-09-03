package pe.com.relari.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.com.relari.TestJsonConverter;
import pe.com.relari.dao.ws.JsonPlaceHolderApi;
import pe.com.relari.dao.ws.model.UserResponse;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {

    @Mock
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @InjectMocks
    UserResource userResource;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUser() {

        var response = TestJsonConverter.readDataFromFileJson("user_1.json", UserResponse.class);
        Mockito.when(jsonPlaceHolderApi.getUser(Mockito.anyInt())).thenReturn(response);

        var result = userResource.getUser(1);
        assertEquals(1, result.getId());
    }
}