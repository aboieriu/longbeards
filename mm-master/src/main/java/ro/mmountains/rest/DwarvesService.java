package ro.mmountains.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mmountains.service.IDwarfAppService;
import ro.mmountains.view.DwarfView;

import java.util.List;

/**
 * Created by aboieriu on 7/11/16.
 */
@RestController
@RequestMapping("/dwarves")
public class DwarvesService {

    @Autowired
    private IDwarfAppService dwarfAppService;

    @RequestMapping()
    public List<DwarfView> dwarvesIndex() {
        return dwarfAppService.getAll();
    }
}