package Hospital.System.service;

import Hospital.System.model.Log;
import Hospital.System.model.viewModel.LogViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LogService {
    void save(Log log);

    Page<LogViewModel> getAll(Pageable pageable);
}