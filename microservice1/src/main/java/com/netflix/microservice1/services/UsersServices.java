package com.netflix.microservice1.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.common.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.hateoas.PagedModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsersServices {

    public List<User> getAllUsers() {
        RestTemplate restTemplate = restTemplate();
        String url = "http://localhost:8081/users/?page={page}&size={size}";

        ResponseEntity<PagedModel<User>> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<PagedModel<User>>() {
                },
                null, 0, 100);
        PagedModel<User> resources = responseEntity.getBody();
        List<User> users = new ArrayList(resources.getContent());
        return new ArrayList(resources.getContent());
    }
    private RestTemplate restTemplate() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new Jackson2HalModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);
        return new RestTemplate(Arrays.asList(converter));
    }
    public User saveUser(User user) {
        RestTemplate restTemplate = restTemplate();
        String url = "http://localhost:8081/users/";

        ResponseEntity<User> result = restTemplate.postForEntity(url, user, User.class);
        return result.getBody();
    }
}
