package com.bbva.MicroserviceCard.mapper;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "sping")
public interface ICardMapper {
    Card toEntity(CardDTO cardDTO);
    CardDTO toDTO(Card card);
    List<CardDTO> ListToDtoList(List<Card> cards);
}
