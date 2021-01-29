package me.junsu.demospringmvc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MyConverter implements Converter<String, User> {

    @Override
    public User convert(String id) {
        return new User(Long.parseLong(id), "Mr.Lee");
    }
}
