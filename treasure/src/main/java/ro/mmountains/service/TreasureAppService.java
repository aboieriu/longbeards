package ro.mmountains.service;

import com.google.common.base.Preconditions;
import ro.mmountains.api.ITreasureApi;
import ro.mmountains.domain.Treasure;
import ro.mmountains.view.TreasureConverter;
import ro.mmountains.view.TreasureView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureAppService implements ITreasureAppService {

    private final ITreasureApi treasureApi;

    private TreasureConverter treasureConverter = new TreasureConverter();

    public TreasureAppService(ITreasureApi treasureApi) {
        this.treasureApi = Preconditions.checkNotNull(treasureApi, "treasureAPi must be initialized");
    }

    public List<TreasureView> getAll() {
        List<Treasure> treasures = treasureApi.getAll();
        return treasures.stream().map(treasure ->  treasureConverter.reverse(treasure)).collect(Collectors.toList());
    }

    public ITreasureApi getTreasureApi() {
        return treasureApi;
    }
}
