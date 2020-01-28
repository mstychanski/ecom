package ecom.pac.ctrl;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Frontflip {

    @RequestMapping("/frontflip")
    public String frontflip() {
        return "FRONTFLIP";
    }
}
