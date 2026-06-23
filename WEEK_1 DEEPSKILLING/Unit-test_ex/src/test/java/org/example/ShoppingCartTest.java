package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShoppingCartTest {




    @Test
    public void paymentChecker(){
        PaymentService paymentService=mock(PaymentService.class);
        when(paymentService.makePayment(100)).thenReturn(true);
        System.out.println("PaymentService method called"+paymentService.makePayment(100));
        ShoppingCart cart=new ShoppingCart(paymentService);
        String res=cart.checkout(100);
        assertEquals("Order Placed",res);
        verify(paymentService,times(2)).makePayment((100));

    }
    @Test
    public void paymentchechbecomesfalse(){
        PaymentService paymentService=mock(PaymentService.class);
        System.out.println("PaymentService method called"+paymentService.makePayment(100));
        ShoppingCart cart=new ShoppingCart(paymentService);
        String res=cart.checkout(100);
        assertEquals("Order Placed",res);
        verify(paymentService).makePayment((100));

    }



}