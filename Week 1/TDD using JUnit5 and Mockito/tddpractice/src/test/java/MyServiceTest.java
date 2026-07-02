import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApiStubbing() {
        // 1. Arrange: Create the mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // 2. Arrange: Stub the method to return a safe, predefined value
        // This ensures our test doesn't actually hit the real internet!
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Pass the fake API into our real service
        MyService service = new MyService(mockApi);

        // 3. Act: Call the method we are testing
        String result = service.fetchData();

        // 4. Assert: Verify the service returned the data from our mock
        assertEquals("Mock Data", result, "The service should return the mocked data");
    }

    @Test
    public void testVerifyInteraction() {
        // 1. Arrange: Create the mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Act: Call the method
        service.fetchData();

        // 3. Assert (Verify): Ensure that the service actually called getData() on the API exactly once
        verify(mockApi, times(1)).getData();
    }
}