package com.bbva.MicroservicePurchase.mapper;

import com.bbva.MicroservicePurchase.dto.PurchaseDTO;
import com.bbva.MicroservicePurchase.entity.Purchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    Purchase toEntity(PurchaseDTO purchaseDTO);

    PurchaseDTO toDTO(Purchase purchase);

    List<PurchaseDTO> ListToDtoList(List<Purchase> purchase);
}
