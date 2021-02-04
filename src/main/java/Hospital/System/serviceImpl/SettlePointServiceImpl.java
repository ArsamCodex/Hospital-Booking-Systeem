package Hospital.System.serviceImpl;

import Hospital.System.model.SettlePoint;
import Hospital.System.model.viewModel.SettlePointViewModel;
import Hospital.System.repository.SettlePointRepository;
import Hospital.System.service.SettlePointService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettlePointServiceImpl implements SettlePointService {
    private SettlePointRepository settlePointRepository;

    private ModelMapper modelMapper;

    @Autowired
    public SettlePointServiceImpl(SettlePointRepository settlePointRepository, ModelMapper modelMapper) {
        this.settlePointRepository = settlePointRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SettlePointViewModel> getAll() {
        List<SettlePoint> settlePoints = this.settlePointRepository.findAllByOrderByName();
        List<SettlePointViewModel> settlePointViewModels = new ArrayList<>();
        for (SettlePoint settlePoint : settlePoints) {
            SettlePointViewModel settlePointViewModel = this.modelMapper.map(settlePoint, SettlePointViewModel.class);
            settlePointViewModels.add(settlePointViewModel);
        }

        return settlePointViewModels;
    }

    @Override
    public SettlePoint getById(long id) {
        return this.settlePointRepository.findById(id).orElse(null);
    }
}