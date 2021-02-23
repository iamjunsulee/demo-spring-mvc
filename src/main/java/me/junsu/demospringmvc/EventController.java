package me.junsu.demospringmvc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    private final EventService eventService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    /*
    argument resolver
     */
    @GetMapping("/parameter")
    @ResponseBody
    public String getParameter(Header header) {
        logger.info("[user-agent]" + header.get("user-agent"));
        return "hi";
    }
//    @GetMapping("/{id}")
//    @ResponseBody
//    public User getId(@PathVariable long id) {
//        return
//    }

    /*
    http method
     */
//    @GetMapping("/method")
    @RequestMapping(value = "/method"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getHttpMethodGet() {
        return "get";
    }

    @RequestMapping(value = "/list"
            , headers = HttpHeaders.ALLOW)
    @ResponseBody
    public String getHttpMethod() {
        return "get";
    }

    @PostMapping("/method")
    @ResponseBody
    public String getHttpMethodPost() {
        return "post";
    }

    @GetMapping("/header")
    @ResponseBody
    public String getHttpMethodHeader() {
        return "header";
    }

    @PostMapping("/header")
    @ResponseBody
    public String getHttpMethodHeader2() {
        return "header";
    }

    @HelloBook("/helloBook")
    @ResponseBody
    public String getHelloBook() { return "Hello Book"; }
}
