package me.junsu.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /*
    http message converter
     */
    @GetMapping("/message")
    @ResponseBody
    public User getMessage(@RequestBody User user) {
        return user;
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public User getId(@PathVariable long id) {
//        return
//    }
}
