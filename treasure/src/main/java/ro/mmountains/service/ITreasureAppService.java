package ro.mmountains.service;

import ro.mmountains.view.TreasureView;

import java.util.List;

/**
 * Created by aboieriu on 7/12/16.
 */
public interface ITreasureAppService {
    List<TreasureView> getAll();
    void addTreasure(TreasureView treasureView);
}
