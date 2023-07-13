package com.tietoevry.hike.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tietoevry.hike.model.HikeDetails;
import com.tietoevry.hike.service.HikeInventoryAnalyzeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HikePlannerApi.class)
class HikePlannerApiTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HikeInventoryAnalyzeService hikeInventoryAnalyzeService;

    @Test
    public void testHikeThatHikeInventoryApiCallReturnData() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/hike/inventory")
                        .content(new ObjectMapper().writeValueAsString(new HikeDetails(10d, "Summer", "gravel")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}