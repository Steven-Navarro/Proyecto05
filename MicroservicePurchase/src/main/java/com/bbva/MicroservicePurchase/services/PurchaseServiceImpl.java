package com.bbva.MicroservicePurchase.services;

import com.bbva.MicroservicePurchase.dto.PurchaseDTO;
import com.bbva.MicroservicePurchase.entity.Purchase;
import com.bbva.MicroservicePurchase.mapper.IPurchaseMapper;
import com.bbva.MicroservicePurchase.repositories.IPurchaseRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper(componentModel = "spring")
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private IPurchaseMapper purchaseMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseDTO> getAllPurchase() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<PurchaseDTO> purchasesDTO = purchaseMapper.ListToDtoList(purchases);
        return purchasesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseDTO getPurchase(Integer purchaseID) {
        Purchase purchase = purchaseRepository.findById(purchaseID).orElseThrow();
        PurchaseDTO purchaseDTO = purchaseMapper.toDTO(purchase);
        return purchaseDTO;
    }
}
