//package com.invo.matchela.api.entity.controller.impl;
//
//import com.invo.matchela.api.entity.cards.Card;
//import com.invo.matchela.api.entity.controller.impl.CardControllerImpl;
//import com.invo.matchela.api.entity.controller.impl.CustomUtils;
//import com.invo.matchela.api.entity.dto.CardDTO;
//import com.invo.matchela.api.entity.mapper.CardMapper;
//import com.invo.matchela.api.entity.mapper.ReferenceMapper;
//import com.invo.matchela.api.entity.service.CardService;
//import org.aspectj.lang.annotation.Before;
//import org.hamcrest.Matchers;
//import org.hamcrest.core.Is;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//public class CardControllerImplTest {
//    //TODO: create the data Test generator class CardBuilder
//    private static final String ENDPOINT_URL = "/cards";
//    @MockBean
//    private ReferenceMapper referenceMapper;
//    @InjectMocks
//    private CardControllerImpl cardController;
//    @MockBean
//    private CardService cardService;
//    @MockBean
//    private CardMapper cardMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.cardController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(cardMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CardBuilder.getListDTO());
//
//        Mockito.when(cardService.findAll()).thenReturn(CardBuilder.getListEntities());
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
//
//    }
//
//    @Test
//    public void getById() throws Exception {
//        Mockito.when(cardMapper.asDTO(ArgumentMatchers.any())).thenReturn(CardBuilder.getDTO());
//
//        Mockito.when(cardService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CardBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(cardService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(cardService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(cardMapper.asEntity(ArgumentMatchers.any())).thenReturn(CardBuilder.getEntity());
//        Mockito.when(cardService.save(ArgumentMatchers.any(Card.class))).thenReturn(CardBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(CardBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(cardService, Mockito.times(1)).save(ArgumentMatchers.any(Card.class));
//        Mockito.verifyNoMoreInteractions(cardService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(cardMapper.asEntity(ArgumentMatchers.any())).thenReturn(CardBuilder.getEntity());
//        Mockito.when(cardService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CardBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(CardBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(cardService, Mockito.times(1)).update(ArgumentMatchers.any(Card.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(cardService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(cardService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(cardService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(cardService);
//    }