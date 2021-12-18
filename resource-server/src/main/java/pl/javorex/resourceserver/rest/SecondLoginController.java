package pl.javorex.resourceserver.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondLoginController {

@GetMapping("/login/alternative")
String getLoginAlternative() {
    return "Alternative logging.";
}
}
