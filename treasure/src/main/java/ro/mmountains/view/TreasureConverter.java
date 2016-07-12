package ro.mmountains.view;

import ro.mmountains.domain.Treasure;

/**
 * Created by aboieriu on 7/12/16.
 */
public class TreasureConverter {

    private DwarfConverter dwarfConverter = new DwarfConverter();

    public TreasureView reverse(Treasure treasure) {
        return new TreasureView(treasure.getId(), treasure.getType(), treasure.getValue(), dwarfConverter.reverse(treasure.getDwarf()));
    }

    public Treasure forward(TreasureView treasureView) {
        if (treasureView == null) {
            return null;
        }
        return new Treasure(treasureView.getId(), treasureView.getType(), treasureView.getValue(), false, dwarfConverter.forward(treasureView.getDwarf()));
    }
}
