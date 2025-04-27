package com.posgateway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private TerminalConnector terminalConnector;

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService(terminalConnector);
    }

    @Test
    void testAuthorizePayment_Success() {
        // Arrange
        double amount = 100.0;
        when(terminalConnector.authorize(amount)).thenReturn(true);

        // Act
        TransactionResult result = paymentService.authorize(amount);

        // Assert
        assertTrue(result.isSuccess());
        verify(terminalConnector).authorize(amount);
    }

    @Test
    void testAuthorizePayment_Failure() {
        // Arrange
        double amount = 100.0;
        when(terminalConnector.authorize(amount)).thenReturn(false);

        // Act
        TransactionResult result = paymentService.authorize(amount);

        // Assert
        assertFalse(result.isSuccess());
        verify(terminalConnector).authorize(amount);
    }
} 