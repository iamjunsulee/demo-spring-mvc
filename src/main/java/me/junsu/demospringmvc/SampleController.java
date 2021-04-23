package me.junsu.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SampleController {
    //공통적으로 사용할 값의 경우, @ModelAttribute를 사용하면 좋다.
    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "seminar", "social", "hobby"));
    }

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
        return "/events/form";
    }

    @PostMapping("/event/create")
    //public Event createForm(@RequestParam String name, @RequestParam int limitOfEnrollment) {
    public String createForm(@ModelAttribute Event event, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
//            System.out.println("===========================================");
//            bindingResult.getAllErrors().forEach(b -> System.out.println(b.toString()));
//            System.out.println("===========================================");
            return "/events/form";
        }
        List<Event> events = new ArrayList<>();
        events.add(event);
        model.addAttribute("events", events);

        return "redirect:/event/list";
    }

    @GetMapping("/event/list")
    public String getList(Model model) {
        Event event = new Event();
        event.setLimitOfEnrollment(10);
        event.setId(1L);
        event.setEndDateTime(LocalDateTime.now());
        event.setEndDateTime(LocalDateTime.now());
        event.setName("hihihihi");

        List<Event> events = new ArrayList<>();
        events.add(event);
        model.addAttribute("events", events);

        return "/events/list";
    }
}
