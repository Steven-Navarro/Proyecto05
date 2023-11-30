package com.bbva.MicroservicePurchase.services;

import com.bbva.MicroservicePurchase.dto.PurchaseDTO;

import java.util.List;

public interface IPurchaseService {

    List<PurchaseDTO> getAllPurchase();

    PurchaseDTO getPurchase(Integer purchaseID);
}
