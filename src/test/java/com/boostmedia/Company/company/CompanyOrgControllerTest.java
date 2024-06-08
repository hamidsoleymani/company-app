package com.boostmedia.Company.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
class CompanyOrgControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CompanyService companyService;

    final String urlCompany = "/api/v1/company/";

    @Test
    void save() throws Exception {
        CompanyDto c = companyService.save(new CompanyDto(null, "Akros", Collections.EMPTY_LIST));
        CompanyDto m = companyService.save(new CompanyDto(null, "Mica", Collections.EMPTY_LIST));
        var mvc = mockMvc.perform(
                MockMvcRequestBuilders.get(urlCompany + c.id())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        CompanyDto company = objectMapper.readValue(mvc.getResponse().getContentAsString(), CompanyDto.class);

        assertEquals(c.id(), company.id());
        assertEquals(c.companyName(), company.companyName());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(urlCompany + "all").contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        ArrayList<CompanyDto> arrayList = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ArrayList.class);
        assertEquals(arrayList.size(), 2);
        // asser
    }

    /*
     mockMvc.perform(
            post("$ROOT_BUERGER_LISTE$B_CREATE")
                .content(objectMapper.writeValueAsString(vorSpeicherung))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk).andReturn()
     */

    @Test
    public void post() throws Exception {
        String akros2 = objectMapper.writeValueAsString(new CompanyDto(null, "Akros2", Collections.EMPTY_LIST));
        MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/company/save").
                contentType(MediaType.APPLICATION_JSON).
                content(akros2)
        ).andReturn();
        CompanyDto company = objectMapper.readValue(mvc.getResponse().getContentAsString(), CompanyDto.class);
        company.id();
    }




}
