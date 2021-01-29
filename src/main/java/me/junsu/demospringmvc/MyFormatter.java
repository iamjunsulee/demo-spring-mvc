package me.junsu.demospringmvc;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MyFormatter implements Formatter<User> {
    @Override
    public User parse(String s, Locale locale) throws ParseException {
        User user = new User();
        user.setName(s);
        return user;
    }

    @Override
    public String print(User user, Locale locale) {
        return null;
    }
}
