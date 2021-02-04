package Hospital.System.service;

import Hospital.System.model.Appointment;
import Hospital.System.model.bindingModel.AddAppointmentModel;
import Hospital.System.model.viewModel.AppointmentDateViewModel;
import Hospital.System.model.viewModel.AppointmentViewModel;
import Hospital.System.model.viewModel.DoctorViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    void save(AddAppointmentModel addAppointmentModel);

    List<AppointmentDateViewModel> getAllForDateAndDoctor(Date date, long doctorId);

    List<AppointmentViewModel> getAllForPatientById(long patientId);

    Page<AppointmentViewModel> getAllForPatientById(long patientId, Pageable pageable);

    List<AppointmentViewModel> getAllForDoctorById(long doctorId);

    Page<AppointmentViewModel> getAllForDoctorById(long doctorId, Pageable pageable);

    AppointmentViewModel getByDateAndDoctorId(Date date, long doctorId);

    AppointmentViewModel getById(long id);


}

