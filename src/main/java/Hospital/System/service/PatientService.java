package Hospital.System.service;

import Hospital.System.model.Patient;
import Hospital.System.model.bindingModel.EditPatientModel;
import Hospital.System.model.bindingModel.PatientRegistrationModel;
import Hospital.System.model.viewModel.PatientBasicViewModel;
import Hospital.System.model.viewModel.PatientViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
//    void create(PatientRegistrationModel registrationModel);
//
//    void save(EditPatientModel editPatientModel);

//    PatientViewModel getById(long id);
//
//    Patient getByUserId(long userId);
//
//    EditPatientModel getEditModelByUserId(long userId);
//
//    PatientBasicViewModel getBasicById(long id);
//
//    List<PatientBasicViewModel> getPatientsByDoctorId(Pageable pageable,long doctorId);
//
//    Page<PatientViewModel> getPatientsByDoctorId(Pageable pageable, long doctorId);
//
//    Page<PatientViewModel> getAll(Pageable pageable);

    void create(PatientRegistrationModel registrationModel);

    void save(EditPatientModel editPatientModel);

    PatientViewModel getById(long id);

    Patient getByUserId(long userId);

    EditPatientModel getEditModelByUserId(long userId);

    PatientBasicViewModel getBasicById(long id);

    List<PatientBasicViewModel> getPatientsByDoctorId(long doctorId);

    Page<PatientViewModel> getPatientsByDoctorId(Pageable pageable, long doctorId);

    Page<PatientViewModel> getAll(Pageable pageable);
}