package springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * The goal of this class is to test the controller using a MockMvc object without embedded server
 */
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
public class HelloControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc; // injected with @AutoConfigureMockMvc

    @Test
    public void shouldReturnOurText() throws Exception {
        //technically this would count as one test. for the sake of time I am keeping it as this one test, it can be placed into different methods to test
        //everything individually, but I dont have the time for it.

       //checking if we can populate dropdown lists.
    this.mockMvc
       .perform(get("/supportedMetricTemp")) // perform a request that can be chained
       .andDo(print()) // we log the result
       .andExpect(content().string(containsString("CELSIUS"))); // we check that the Body of the answer contains our expectation
    this.mockMvc
       .perform(get("/supportedImperialTemp")) // perform a request that can be chained
       .andDo(print()) // we log the result
       .andExpect(content().string(containsString("FARENHEIT"))); // we check that the Body of the answer contains our expectation
   
       //temp
    this.mockMvc
       .perform(get("/celsiusToFarenheit/{num}", "0")) // perform a request that can be chained
       .andDo(print()) // we log the result
       .andExpect(content().string(containsString("32"))); // we check that the Body of the answer contains our expectation
    this.mockMvc
       .perform(get("/farenheitToCelsius/{num}", "0")) // perform a request that can be chained
       .andDo(print()) // we log the result
       .andExpect(content().string(containsString("-17.777"))); // we check that the Body of the answer contains our expectation

       //length
       //metric to metric
    this.mockMvc
       .perform(get("/Length/{num}/{str1}/{str2}", "1000","MILLIMETERS","METERS")) // perform a request that can be chained
       .andDo(print()) // we log the result
       .andExpect(content().string(containsString("1"))); // we check that the Body of the answer contains our expectation
        //imperial to imperial
    this.mockMvc
        .perform(get("/Length/{num}/{str1}/{str2}", "1000","INCHES","HANDS")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("250"))); // we check that the Body of the answer contains our expectation
     this.mockMvc
        .perform(get("/Length/{num}/{str1}/{str2}", "1000","MILLIMETERS","INCHES")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("25400.0508"))); // we check that the Body of the answer contains our expectation
         
       ///mass
       //metric to metric
    this.mockMvc
        .perform(get("/Mass/{num}/{str1}/{str2}", "1000","MILLIGRAM","GRAM")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("1"))); // we check that the Body of the answer contains our expectation
     //imperial to imperial
    this.mockMvc
        .perform(get("/Mass/{num}/{str1}/{str2}", "500","OUNCE","POUND")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("31.25"))); // we check that the Body of the answer contains our expectation
    this.mockMvc
        .perform(get("/Mass/{num}/{str1}/{str2}", "1000","MILLIGRAM","OUNCE")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("0.03527396194000"))); // we check that the Body of the answer contains our expectation
        //imperial to imperial
     this.mockMvc
       .perform(get("/Mass/{num}/{str1}/{str2}", "1000","OUNCE","MILLIGRAM")) // perform a request that can be chained
        .andDo(print()) // we log the result
        .andExpect(content().string(containsString("28349500"))); // we check that the Body of the answer contains our expectation

    }

}
