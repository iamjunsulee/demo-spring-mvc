package me.junsu.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/event/form")
    public String getForm(Model model) {
        Event event = new Event();
        event.setId(1L);
        event.setName("hi");
        event.setStartDateTime(LocalDateTime.now());
        event.setEndDateTime(LocalDateTime.now());
        event.setLimitOfEnrollment(10);
        model.addAttribute("event", event);
        return "events/form";
    }

    @PostMapping("/event/create")
    @ResponseBody
    public Event createForm(@RequestParam String name, @RequestParam int limitOfEnrollment) {
        Event event = new Event();
        event.setName(name);
        event.setLimitOfEnrollment(limitOfEnrollment);
        return event;
    }
}
