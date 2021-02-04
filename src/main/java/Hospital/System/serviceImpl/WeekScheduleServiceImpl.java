package Hospital.System.serviceImpl;

import Hospital.System.model.DayOfWeek;
import Hospital.System.model.DaySchedule;
import Hospital.System.model.WeekSchedule;
import Hospital.System.model.bindingModel.DayScheduleModel;
import Hospital.System.model.bindingModel.EditDayScheduleModel;
import Hospital.System.model.bindingModel.EditWeekScheduleModel;
import Hospital.System.repository.WeekScheduleRepository;
import Hospital.System.service.DayScheduleService;
import Hospital.System.service.WeekScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class WeekScheduleServiceImpl implements WeekScheduleService {
    private WeekScheduleRepository weekScheduleRepository;

    private ModelMapper modelMapper;

    private DayScheduleService dayScheduleService;

    @Autowired
    public WeekScheduleServiceImpl(WeekScheduleRepository weekScheduleRepository, ModelMapper modelMapper,
                                   DayScheduleService dayScheduleService) {
        this.weekScheduleRepository = weekScheduleRepository;
        this.modelMapper = modelMapper;
        this.dayScheduleService = dayScheduleService;
    }

    @Override
    public WeekSchedule createDefault() {
        WeekSchedule weekSchedule = this.weekScheduleRepository.saveAndFlush(new WeekSchedule());

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            DayScheduleModel dayScheduleModel = new DayScheduleModel();
            dayScheduleModel.setDayOfWeek(dayOfWeek.toString());
            dayScheduleModel.setStartTime(Time.valueOf("00:00:00"));
            dayScheduleModel.setEndTime(Time.valueOf("00:00:00"));
            dayScheduleModel.setWeekSchedule(weekSchedule);

            this.dayScheduleService.create(dayScheduleModel);
        }

        return weekSchedule;
    }

    @Override
    public EditWeekScheduleModel getById(long id) {
        WeekSchedule weekSchedule = this.weekScheduleRepository.findById(id).orElse(null);

        EditWeekScheduleModel editWeekScheduleModel = this.modelMapper.map(weekSchedule, EditWeekScheduleModel.class);
        for (DaySchedule daySchedule : weekSchedule.getDaySchedules()) {
            EditDayScheduleModel editDayScheduleModel = this.modelMapper.map(daySchedule, EditDayScheduleModel.class);
            editDayScheduleModel.setStartTimeStr(daySchedule.getStartTime().toString());
            editDayScheduleModel.setEndTimeStr(daySchedule.getEndTime().toString());
            editWeekScheduleModel.getEditDayScheduleModels().add(editDayScheduleModel);
        }

        return editWeekScheduleModel;
    }

    @Override
    public void save(EditWeekScheduleModel editWeekScheduleModel) {
        WeekSchedule weekSchedule = this.weekScheduleRepository.getOne(editWeekScheduleModel.getId());
        weekSchedule.setAppointmentDuration(editWeekScheduleModel.getAppointmentDuration());
        this.weekScheduleRepository.saveAndFlush(weekSchedule);

        for (EditDayScheduleModel editDayScheduleModel : editWeekScheduleModel.getEditDayScheduleModels()) {
            this.dayScheduleService.save(editDayScheduleModel);
        }
    }
}