package Hospital.System.service;

import Hospital.System.model.SettlePoint;
import Hospital.System.model.viewModel.SettlePointViewModel;

import java.util.List;

public interface SettlePointService {
    List<SettlePointViewModel> getAll();

    SettlePoint getById(long id);
}