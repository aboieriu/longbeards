package ro.mmountains.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.mmountains.service.ITreasureAppService;
import ro.mmountains.view.TreasureView;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
@RestController
@RequestMapping("/treasure")
public class TrasureService {

    @Autowired
    private ITreasureAppService treasureAppService;

    @RequestMapping()
    public List<TreasureView> getTreasures(){
        return treasureAppService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTreasure(@RequestBody TreasureView treasureView) {
        treasureAppService.addTreasure(treasureView);
    }
}
