package com.senlainc.mock.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senlainc.controller.ProductController;
import com.senlainc.dto.product.SaveProductRequest;
import com.senlainc.entity.Product;
import com.senlainc.entity.User;
import com.senlainc.routes.ProductRoutes;
import com.senlainc.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testAddProductForSale() throws Exception {
        SaveProductRequest request = new SaveProductRequest();
        request.setUserId(1l);
        request.setPrice(new BigDecimal("20000"));
        request.setName("name");
        request.setDescription("about");

        Product product = new Product();
        User user = new User();
        user.setId(1l);
        product.setId(2l);
        product.setUser(user);
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(request);

        when(productService.addProduct(request)).thenReturn(product);

        MvcResult mvcResult = mockMvc.perform(post(ProductRoutes.PRODUCT)
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        Assert.assertNotNull(mvcResult);

    }

    @Test
    public void testBuyProduct() throws Exception {
        doNothing().when(productService).buyProduct(2l, 1l);

        mockMvc.perform(get(ProductRoutes.BUY_PRODUCT, 2l, 1l))
                .andExpect(status().isOk());

        verify(productService, atLeastOnce()).buyProduct(anyLong(),anyLong());
    }
}
