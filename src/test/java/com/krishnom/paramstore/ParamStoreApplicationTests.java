package com.krishnom.paramstore;

import com.krishnom.paramstore.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParamStoreApplicationTests {
	@Autowired
	private MainController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {

		assertThat(controller).isNotNull();
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("This is default response from  param store rest server")));
	}

	@Test
	public void shouldReturnSingleParamForSpecifiedKey() throws Exception {
		this.mockMvc.perform(get("/params/get?id=author")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("This is default response from  param store rest server")));
	}

	@Test
	public void shouldReturnAllParamByDefault() throws Exception {
		this.mockMvc.perform(get("/params")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{}")));
	}


}
