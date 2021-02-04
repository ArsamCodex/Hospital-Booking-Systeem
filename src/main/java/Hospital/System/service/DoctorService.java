package Hospital.System.service;

import Hospital.System.model.Doctor;
import Hospital.System.model.bindingModel.DoctorRegistrationModel;
import Hospital.System.model.bindingModel.EditDoctorModel;
import Hospital.System.model.bindingModel.EditDoctorPictureModel;
import Hospital.System.model.viewModel.DoctorSelectViewModel;
import Hospital.System.model.viewModel.DoctorViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DoctorService {
//    void create(DoctorRegistrationModel registrationModel);
//
//    void save(EditDoctorModel editDoctorModel);
//
//    void savePicture(EditDoctorPictureModel editDoctorPictureModel);
//
//    Doctor getById(long id);
//
//    DoctorViewModel getViewModelById(long id);
//
//    EditDoctorPictureModel getPictureModelByUserId(long id);
//
//    Doctor getByUserId(long userId);
//
//    EditDoctorModel getEditModelByUserId(long userId);
//
//    DoctorSelectViewModel getModelByUserId(long userId);
//
//    List<DoctorSelectViewModel> getAllSelect();

//    Page<DoctorViewModel> getAll(Pageable pageable);
void create(DoctorRegistrationModel registrationModel);

    void save(EditDoctorModel editDoctorModel);

    void savePicture(EditDoctorPictureModel editDoctorPictureModel);

    Doctor getById(long id);

    DoctorViewModel getViewModelById(long id);

    EditDoctorPictureModel getPictureModelByUserId(long id);

    Doctor getByUserId(long userId);

    EditDoctorModel getEditModelByUserId(long userId);

    DoctorSelectViewModel getModelByUserId(long userId);

    List<DoctorSelectViewModel> getAllSelect();

    Page<DoctorViewModel> getAll(Pageable pageable);
}
