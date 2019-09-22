package com.udacity.PriceMicroservice;

import com.udacity.PriceMicroservice.entity.Price;
import com.udacity.PriceMicroservice.repository.PriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PriceMicroserviceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<Price> json;

	@Test
	public void contextLoads() {
	}

	/**
	 * Tests for successful creation of new price in the system
	 * @throws Exception when price creation fails in the system
	 */
	@Test
	public void createPrice() throws Exception {
		Price price = getPrice();
		price.setId(1L);
		mvc.perform(
				post(new URI("/prices"))
						.content(json.write(price).getJson())
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());
	}

	/**
	 * Tests the read operation for a single price by ID.
	 * @throws Exception if the read operation for a single price fails
	 */
	@Test
	public void findPrice() throws Exception {
		Price price = getPrice();
		mvc.perform(get("/prices/1")
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.currency").value(price.getCurrency()))
				.andExpect(jsonPath("$.price").value(new Long(String.valueOf(price.getPrice()))));
	}


	/**
	 * Creates an example Price object for use in testing.
	 * @return an example Price object
	 */
	private Price getPrice() {
		Price price = new Price();
		price.setCurrency("USD");
		price.setPrice(new BigDecimal(3422));
		return price;
	}
}
