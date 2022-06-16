package com.invo.matchela.api.entity.controller.impl;

import com.invo.matchela.api.entity.cards.MatchRequest;
import com.invo.matchela.api.entity.controller.impl.CustomUtils;
import com.invo.matchela.api.entity.controller.impl.MatchRequestControllerImpl;
import com.invo.matchela.api.entity.dto.MatchRequestDTO;
import com.invo.matchela.api.entity.mapper.MatchRequestMapper;
import com.invo.matchela.api.entity.service.MatchRequestService;
import com.invo.matchela.api.mapper.ReferenceMapper;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MatchRequestControllerImplTest {
    //TODO: create the data Test generator class MatchRequestBuilder
    private static final String ENDPOINT_URL = "/match-requests";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private MatchRequestControllerImpl matchrequestController;
    @MockBean
    private MatchRequestService matchrequestService;
    @MockBean
    private MatchRequestMapper matchrequestMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.matchrequestController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(matchrequestMapper.asDTOList(ArgumentMatchers.any())).thenReturn(MatchRequestBuilder.getListDTO());

        Mockito.when(matchrequestService.findAll()).thenReturn(MatchRequestBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(matchrequestMapper.asDTO(ArgumentMatchers.any())).thenReturn(MatchRequestBuilder.getDTO());

        Mockito.when(matchrequestService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(MatchRequestBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(matchrequestService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(matchrequestService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(matchrequestMapper.asEntity(ArgumentMatchers.any())).thenReturn(MatchRequestBuilder.getEntity());
        Mockito.when(matchrequestService.save(ArgumentMatchers.any(MatchRequest.class))).thenReturn(MatchRequestBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(MatchRequestBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(matchrequestService, Mockito.times(1)).save(ArgumentMatchers.any(MatchRequest.class));
        Mockito.verifyNoMoreInteractions(matchrequestService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(matchrequestMapper.asEntity(ArgumentMatchers.any())).thenReturn(MatchRequestBuilder.getEntity());
        Mockito.when(matchrequestService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(MatchRequestBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(MatchRequestBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(matchrequestService, Mockito.times(1)).update(ArgumentMatchers.any(MatchRequest.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(matchrequestService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(matchrequestService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(matchrequestService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(matchrequestService);
    }