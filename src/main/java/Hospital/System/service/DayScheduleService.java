package Hospital.System.service;

import Hospital.System.model.bindingModel.DayScheduleModel;
import Hospital.System.model.bindingModel.EditDayScheduleModel;

public interface DayScheduleService {
    void create(DayScheduleModel dayScheduleModel);

    void save(EditDayScheduleModel editDayScheduleModel);
    //getById(long id);
}