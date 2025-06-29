package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.api.ExternalApi;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {
    
    @Mock
    private ExternalApi mockApi;
    
    private MyService service;
    
    @BeforeEach
    void setUp() {
        service = new MyService(mockApi);
    }
    
    /**
     * Exercise 1: Basic mocking and stubbing test case.
     */
    @Test
    public void testExternalApi() {
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act: Call the method under test
        String result = service.fetchData();
        
        // Assert: Verify the expected result
        assertEquals("Mock Data", result);
        
        // Verify that the mock method was called
        verify(mockApi).getData();
    }
    
    @Test
    void testFetchDataById() {
        // Arrange
        when(mockApi.isAvailable()).thenReturn(true);
        when(mockApi.getDataById("123")).thenReturn("Data for ID 123");
        
        // Act
        String result = service.fetchDataById("123");
        
        // Assert
        assertEquals("Data for ID 123", result);
        verify(mockApi).isAvailable();
        verify(mockApi).getDataById("123");
    }
    
    @Test
    void testFetchDataByIdWhenServiceUnavailable() {
        // Arrange
        when(mockApi.isAvailable()).thenReturn(false);
        
        // Act
        String result = service.fetchDataById("123");
        
        // Assert
        assertEquals("Service unavailable", result);
        verify(mockApi).isAvailable();
        // Verify that getDataById was NOT called when service is unavailable
        verify(mockApi, never()).getDataById(anyString());
    }
    
    @Test
    void testProcessDataWithNullData() {
        // Arrange
        when(mockApi.getData()).thenReturn(null);
        
        // Act
        String result = service.processData();
        
        // Assert
        assertEquals("No data available", result);
        verify(mockApi).getData();
    }
    

    @Test
    void testProcessDataWithEmptyData() {
        // Arrange
        when(mockApi.getData()).thenReturn("");
        
        // Act
        String result = service.processData();
        
        // Assert
        assertEquals("No data available", result);
        verify(mockApi).getData();
    }
    
    @Test
    void testProcessDataWithValidData() {
        // Arrange
        when(mockApi.getData()).thenReturn("sample data");
        
        // Act
        String result = service.processData();
        
        // Assert
        assertEquals("Processed: SAMPLE DATA", result);
        verify(mockApi).getData();
    }
    

    @Test
    void testServiceStatusWhenHealthy() {
        // Arrange
        when(mockApi.isAvailable()).thenReturn(true);
        
        // Act
        String status = service.getServiceStatus();
        
        // Assert
        assertEquals("Service is healthy", status);
        verify(mockApi).isAvailable();
    }
    

    @Test
    void testServiceStatusWhenDown() {
        // Arrange
        when(mockApi.isAvailable()).thenReturn(false);
        
        // Act
        String status = service.getServiceStatus();
        
        // Assert
        assertEquals("Service is down", status);
        verify(mockApi).isAvailable();
    }
    
    @Test
    void testFetchDataByIdWithArgumentMatchers() {
        // Arrange
        when(mockApi.isAvailable()).thenReturn(true);
        when(mockApi.getDataById(anyString())).thenReturn("Generic data");
        
        // Act
        String result = service.fetchDataById("any-id");
        
        // Assert
        assertEquals("Generic data", result);
        verify(mockApi).isAvailable();
        verify(mockApi).getDataById("any-id");
    }
    
    @Test
    void testMultipleMethodCalls() {
        // Arrange
        when(mockApi.getData()).thenReturn("test data");
        
        // Act
        service.fetchData();
        service.fetchData();
        service.processData();
        
        // Assert
        // Verify getData was called exactly 3 times
        verify(mockApi, times(3)).getData();
    }
}
