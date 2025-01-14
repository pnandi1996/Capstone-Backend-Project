package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.*;
import com.upgrad.FoodOrderingApp.service.entity.*;
import com.upgrad.FoodOrderingApp.service.exception.PaymentMethodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao; //Handles all data related to the PaymentEntity.


    /* This method is to get Payment By UUID.Takes the paymentId  and returns the PaymentEntity.
    If error throws exception with error code and error message.
    */
    public PaymentEntity getPaymentByUUID(String paymentId) throws PaymentMethodNotFoundException {

        //Calls getPaymentByUUID of the PaymentDao to get corresponding PaymentEntity.
        PaymentEntity paymentEntity = paymentDao.getPaymentByUUID(paymentId);
        if (paymentEntity == null) {      // Checking if Payment entity is null
            throw new PaymentMethodNotFoundException("PNF-002", "No payment method found by this id");
        }
        return paymentEntity;
    }
}