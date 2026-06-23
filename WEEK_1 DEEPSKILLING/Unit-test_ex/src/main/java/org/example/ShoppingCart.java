package org.example;

public class ShoppingCart {
    PaymentService paymentService;

    public ShoppingCart(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public String checkout(int amount){
        if (paymentService.makePayment(amount)){
            return "Order Placed";
        }
        else {
            return "Order Not Placed";
        }
    }
}
