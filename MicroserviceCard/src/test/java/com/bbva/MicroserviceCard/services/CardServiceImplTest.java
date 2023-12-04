package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.entity.CardType;
import com.bbva.MicroserviceCard.mapper.ICardMapper;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CardServiceImplTest {

    @Mock
    private ICardRepository cardRepository;

    @Mock
    private ICardMapper cardMapper;

    @InjectMocks
    private CardServiceImpl cardService;

    @Test
    public void testGetAllCards() {
        List<Card> mockCards = Arrays.asList(
                new Card(1, "1234567890123456", CardType.CREDITO, BigDecimal.valueOf(1000), null),
                new Card(2, "2345678901234567", CardType.DEBITO, BigDecimal.valueOf(500), null)
        );
        Mockito.when(cardRepository.findAll()).thenReturn(mockCards);

        List<CardDTO> mockCardDTOs = Arrays.asList(
                new CardDTO(1, "1234567890123456", CardType.CREDITO, BigDecimal.valueOf(1000), null),
                new CardDTO(2, "2345678901234567", CardType.DEBITO, BigDecimal.valueOf(500), null)
        );
        Mockito.when(cardMapper.toDtoList(mockCards)).thenReturn(mockCardDTOs);

        List<CardDTO> result = cardService.getAllCards();

        assertEquals(mockCardDTOs, result);
    }

    @Test
    public void testGetCard() {
        Card mockCard = new Card(1, "1234567890123456", CardType.CREDITO, BigDecimal.valueOf(1000), null);
        Mockito.when(cardRepository.findById(1)).thenReturn(Optional.of(mockCard));

        CardDTO mockCardDTO = new CardDTO(1, "1234567890123456", CardType.CREDITO, BigDecimal.valueOf(1000), null);
        Mockito.when(cardMapper.toDTO(mockCard)).thenReturn(mockCardDTO);

        CardDTO result = cardService.getCard(1);

        assertEquals(mockCardDTO, result);
    }
}

