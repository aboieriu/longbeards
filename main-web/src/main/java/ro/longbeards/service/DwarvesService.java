package ro.longbeards.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aboieriu on 7/11/16.
 */
@RestController
@RequestMapping("/dwarves")
public class DwarvesService {

    @RequestMapping()
    public String dwarvesIndex() {
        return "Greetings : show dwarves";
    }
}