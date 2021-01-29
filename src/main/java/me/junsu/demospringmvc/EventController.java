package me.junsu.demospringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events/list";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String getHello(@PathVariable String name) {
        return "hello " + name;
    }

    @GetMapping("/hi/{name}")
    @ResponseBody
    public String getHi(User user) {
        return "hi " + user.getName();
    }

    @GetMapping("/user")
    @ResponseBody
    public String getUser(@RequestParam("id") User user) {
        return user.getName();
    }
}
