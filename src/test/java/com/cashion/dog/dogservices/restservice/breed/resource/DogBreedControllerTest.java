package com.cashion.dog.dogservices.restservice.breed.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DogBreedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBreed() throws Exception {
        mockMvc.perform(get("/api/breed/getBreed/{breed}", "Pitbull"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.breed").value("Pitbull"));
    }

    @Test
    public void testGetBreed_NotFound() throws Exception {
        String nonExistentBreed = "NonExistentBreed";
        mockMvc.perform(get("/api/breed/getBreed/{breed}", nonExistentBreed))
                .andExpect(status().isNotFound());
    }
}
