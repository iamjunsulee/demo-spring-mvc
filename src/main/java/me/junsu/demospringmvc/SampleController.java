package me.junsu.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @GetMapping("/event/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Long value) { //mapping에 적은 변수명과 꼭 동일하게 작성하지 않아도 됨.
        Event event = new Event();
        event.setId(value);
        return event;
    }
}
