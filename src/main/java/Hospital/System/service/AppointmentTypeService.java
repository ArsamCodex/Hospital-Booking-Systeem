package Hospital.System.service;

import Hospital.System.model.AppointmentType;
import Hospital.System.model.viewModel.AppointmentTypeViewModel;

import java.util.List;

public interface AppointmentTypeService {
    List<AppointmentTypeViewModel> getAll();


    AppointmentType getById(long id);
}