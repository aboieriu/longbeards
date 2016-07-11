package ro.mmountains.service;

import ro.mmountains.api.IDwarfApi;
import ro.mmountains.domain.Dwarf;
import ro.mmountains.view.DwarfConverter;
import ro.mmountains.view.DwarfView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/12/16.
 */
public class DwarfAppService implements IDwarfAppService {
    private final DwarfConverter dwarfConverter = new DwarfConverter();
    private final IDwarfApi dwarfApi;

    public DwarfAppService(IDwarfApi dwarfApi) {
        this.dwarfApi = dwarfApi;
    }

    public List<DwarfView> getAll() {
        List<Dwarf> dwarfs = dwarfApi.getAll();
        return dwarfs.stream().map(dwarf -> dwarfConverter.reverse(dwarf)).collect(Collectors.toList());
    }
}
