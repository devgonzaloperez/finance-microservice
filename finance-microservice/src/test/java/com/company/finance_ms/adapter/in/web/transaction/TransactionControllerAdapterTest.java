package com.company.finance_ms.adapter.in.web.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.company.finance_ms.domain.transaction.Transaction;
import com.company.finance_ms.port.in.usecase.transaction.TransactionUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(TransactionControllerAdapter.class)
public class TransactionControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private TransactionUseCase transactionUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void testGetAllTransactions() throws Exception {

        //Given.
        Transaction MOCK_TRANSACTION = new Transaction(1L, "Compra", new BigDecimal(100), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
        List<Transaction> MOCK_RESPONSE = List.of(MOCK_TRANSACTION);
        Mockito.when(transactionUseCase.getAllTransactions()).thenReturn(MOCK_RESPONSE);

        //When.
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions").contentType(MediaType.APPLICATION_JSON));

            //Log (Not necessary).
            String resultString = result.andReturn().getResponse().getContentAsString();
            System.out.println(resultString); //El log sale en la pestaña DEBUG CONSOLE.

        //Then.
        result
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(MOCK_RESPONSE)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Compra"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount").value(100));

        Mockito.verify(transactionUseCase, Mockito.times(1)).getAllTransactions();
        
    }

}
