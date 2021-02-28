package me.junsu.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SampleController {
    @GetMapping("/event/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Long value) { //mapping에 적은 변수명과 꼭 동일하게 작성하지 않아도 됨.
        Event event = new Event();
        event.setId(value);
        return event;
    }

    @PostMapping("/event")
    @ResponseBody
    public String getParameter(@RequestParam Optional<String> name) {
        return "name : " + name.orElseGet(() -> "not provided");
    }
}
