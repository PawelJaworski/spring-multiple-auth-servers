package pl.javorex.resourceserver.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SecuredController {
    @GetMapping("/1")
    String one() {
        return "hello world 1";
    }

    @GetMapping("/2")
    String two() {
        return "hello world 2";
    }
}
