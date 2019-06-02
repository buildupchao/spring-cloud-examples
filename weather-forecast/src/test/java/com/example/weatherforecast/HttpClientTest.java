package com.example.weatherforecast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author buildupchao
 * @date 2019-06-02 23:39
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
//        String url = "http://mobile.weather.com.cn/js/citylist.xml";
        String url = "http://www.baidu.com";

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }
}
