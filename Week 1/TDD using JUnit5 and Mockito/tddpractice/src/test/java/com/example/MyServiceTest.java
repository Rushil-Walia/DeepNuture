package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;

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

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        // Simulating the service passing a specific argument to the API
        service.fetchDataById(42); 
        
        // Verify the interaction used the exact argument using eq() matcher
        verify(mockApi).getDataById(eq(42)); 
    }
    
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stubbing the void method (doNothing is default for voids, but explicit here)
        doNothing().when(mockApi).performAction();
        mockApi.performAction();

        // Verify the interaction occurred exactly once
        verify(mockApi, times(1)).performAction();
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stubbing to return different values on consecutive calls
        when(mockApi.getData()).thenReturn("First Result").thenReturn("Second Result");
        assertEquals("First Result", mockApi.getData());
        assertEquals("Second Result", mockApi.getData());
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // Call the methods in a specific order
        mockApi.startProcess();
        mockApi.endProcess();

        // Use InOrder to verify the interaction order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).startProcess();
        inOrder.verify(mockApi).endProcess();
    }

    @Test
    public void testVoidMethodException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Simulated API Error")).when(mockApi).performAction();

        // Assert that the exception is thrown when the method is called
        assertThrows(RuntimeException.class, () -> {
        mockApi.performAction();
        });

        // Verify the interaction actually took place
        verify(mockApi).performAction();
    } 
}