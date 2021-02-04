package Hospital.System.service;

import Hospital.System.model.WeekSchedule;
import Hospital.System.model.bindingModel.EditWeekScheduleModel;

public interface WeekScheduleService {
    EditWeekScheduleModel getById(long id);

    WeekSchedule createDefault();

    void save(EditWeekScheduleModel editWeekScheduleModel);
}