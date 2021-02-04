package Hospital.System.serviceImpl;

import Hospital.System.model.Doctor;
import Hospital.System.model.SettlePoint;
import Hospital.System.model.User;
import Hospital.System.model.WeekSchedule;
import Hospital.System.model.bindingModel.DoctorRegistrationModel;
import Hospital.System.model.bindingModel.EditDoctorModel;
import Hospital.System.model.bindingModel.EditDoctorPictureModel;
import Hospital.System.model.bindingModel.UserRegistrationModel;
import Hospital.System.model.viewModel.DoctorSelectViewModel;
import Hospital.System.model.viewModel.DoctorViewModel;
import Hospital.System.repository.DoctorRepository;
import Hospital.System.service.DoctorService;
import Hospital.System.service.SettlePointService;
import Hospital.System.service.UserService;
import Hospital.System.service.WeekScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    private ModelMapper modelMapper;

    private UserService userService;

    private SettlePointService settlePointService;

    private WeekScheduleService weekScheduleService;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper,
                             UserService userService, SettlePointService settlePointService,
                             WeekScheduleService weekScheduleService) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.settlePointService = settlePointService;
        this.weekScheduleService = weekScheduleService;
    }

    @Override
    public void create(DoctorRegistrationModel registrationModel) {
        User user = this.createDoctorUser(registrationModel);
        SettlePoint settlePoint = this.settlePointService.getById(registrationModel.getSettlePoint());
        WeekSchedule weekSchedule = this.weekScheduleService.createDefault();

        Doctor doctor = this.modelMapper.map(registrationModel, Doctor.class);
        doctor.setUser(user);
        doctor.setSettlePoint(settlePoint);
        doctor.setWeekSchedule(weekSchedule);
        doctor.setWorksWithNZOK(registrationModel.getWorksWithNZOK() == null);

        this.doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void save(EditDoctorModel editDoctorModel) {
        Doctor currentDoctor = this.doctorRepository.findOneByUserId(editDoctorModel.getId());
        Doctor doctor = this.modelMapper.map(editDoctorModel, Doctor.class);

        doctor.setWorksWithNZOK(editDoctorModel.getWorksWithNZOK() == null);
        doctor.setWeekSchedule(currentDoctor.getWeekSchedule());
        doctor.setPatients(currentDoctor.getPatients());
        doctor.setUser(currentDoctor.getUser());
        doctor.setRating(currentDoctor.getRating());
        doctor.setPicturePath(currentDoctor.getPicturePath());

        this.doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void savePicture(EditDoctorPictureModel editDoctorPictureModel) {
        Doctor doctor = this.doctorRepository.findOneByUserId(editDoctorPictureModel.getId());
        doctor.setPicturePath(editDoctorPictureModel.getPicturePath());

        this.doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public Doctor getById(long id) {
        return this.doctorRepository.getOne(id);
    }

    @Override
    public DoctorViewModel getViewModelById(long id) {
        Doctor doctor = this.doctorRepository.getOne(id);

        return this.modelMapper.map(doctor, DoctorViewModel.class);
    }

    @Override
    public EditDoctorPictureModel getPictureModelByUserId(long id) {
        Doctor doctor = this.doctorRepository.findOneByUserId(id);

        return this.modelMapper.map(doctor, EditDoctorPictureModel.class);
    }

    @Override
    public List<DoctorSelectViewModel> getAllSelect() {
        List<Doctor> doctors = this.doctorRepository.findAllByOrderByFirstNameAscLastName();
        List<DoctorSelectViewModel> doctorSelectViewModels = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorSelectViewModel doctorSelectViewModel = this.modelMapper.map(doctor, DoctorSelectViewModel.class);
            doctorSelectViewModels.add(doctorSelectViewModel);
        }

        return doctorSelectViewModels;
    }

    @Override
    public Doctor getByUserId(long userId) {
        return this.doctorRepository.findOneByUserId(userId);
    }


    @Override
    public EditDoctorModel getEditModelByUserId(long userId) {
        Doctor doctor = this.doctorRepository.findOneByUserId(userId);

        return this.modelMapper.map(doctor, EditDoctorModel.class);
    }

    @Override
    public DoctorSelectViewModel getModelByUserId(long userId) {
        Doctor doctor = this.doctorRepository.findOneByUserId(userId);

        return this.modelMapper.map(doctor, DoctorSelectViewModel.class);
    }

    @Override
    public Page<DoctorViewModel> getAll(Pageable pageable) {
        Page<Doctor> doctors = this.doctorRepository.findAll(pageable);
        List<DoctorViewModel> doctorViewModels = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorViewModel doctorViewModel = this.modelMapper.map(doctor, DoctorViewModel.class);
            doctorViewModels.add(doctorViewModel);
        }

        return (Page<DoctorViewModel>) new PageImpl(doctorViewModels, pageable, doctors.getTotalElements());
    }

    private User createDoctorUser(DoctorRegistrationModel registrationModel) {
        UserRegistrationModel userRegistrationModel = this.modelMapper.map(registrationModel, UserRegistrationModel.class);
        String DEFAULT_DOCTOR_ROLE = "ROLE_DOCTOR";
        userRegistrationModel.setAdditionalRole(DEFAULT_DOCTOR_ROLE);
        return this.userService.register(userRegistrationModel);
    }
//    private DoctorRepository doctorRepository;
//
//    private ModelMapper modelMapper;
//
//    private UserService userService;
//
//    private SettlePointService settlePointService;
//
//    private WeekScheduleService weekScheduleService;
//
//    @Autowired
//    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper,
//                             UserService userService, SettlePointService settlePointService,
//                             WeekScheduleService weekScheduleService) {
//        this.doctorRepository = doctorRepository;
//        this.modelMapper = modelMapper;
//        this.userService = userService;
//        this.settlePointService = settlePointService;
//        this.weekScheduleService = weekScheduleService;
//    }
//
//    @Override
//    public void create(DoctorRegistrationModel registrationModel) {
//        User user = this.createDoctorUser(registrationModel);
//        SettlePoint settlePoint = this.settlePointService.getById(registrationModel.getSettlePoint());
//        WeekSchedule weekSchedule = this.weekScheduleService.createDefault();
//
//        Doctor doctor = this.modelMapper.map(registrationModel, Doctor.class);
//        doctor.setUser(user);
//        doctor.setSettlePoint(settlePoint);
//        doctor.setWeekSchedule(weekSchedule);
//        doctor.setWorksWithNZOK(registrationModel.getWorksWithNZOK() == null);
//
//        this.doctorRepository.saveAndFlush(doctor);
//    }
//
//    @Override
//    public void save(EditDoctorModel editDoctorModel) {
//        Doctor currentDoctor = this.doctorRepository.findById(editDoctorModel.getId()).orElse(null);
//        Doctor doctor = this.modelMapper.map(editDoctorModel, Doctor.class);
//
//        doctor.setWorksWithNZOK(editDoctorModel.getWorksWithNZOK() == null);
//        doctor.setWeekSchedule(currentDoctor.getWeekSchedule());
//        doctor.setPatients(currentDoctor.getPatients());
//        doctor.setUser(currentDoctor.getUser());
//        doctor.setRating(currentDoctor.getRating());
//        doctor.setPicturePath(currentDoctor.getPicturePath());
//
//        this.doctorRepository.saveAndFlush(doctor);
//    }
//
//    @Override
//    public void savePicture(EditDoctorPictureModel editDoctorPictureModel) {
//        Doctor doctor = this.doctorRepository.findById(editDoctorPictureModel.getId()).orElse(null);
//        doctor.setPicturePath(editDoctorPictureModel.getPicturePath());
//
//        this.doctorRepository.saveAndFlush(doctor);
//    }
//
//    @Override
//    public Doctor getById(long id) {
//        return this.doctorRepository.getOne(id);
//    }
//
//    @Override
//    public DoctorViewModel getViewModelById(long id) {
//        Doctor doctor = this.doctorRepository.getOne(id);
//
//        return this.modelMapper.map(doctor, DoctorViewModel.class);
//    }
//
//    @Override
//    public EditDoctorPictureModel getPictureModelByUserId(long id) {
//        Doctor doctor = this.doctorRepository.findOneByUserId(id);
//
//        return this.modelMapper.map(doctor, EditDoctorPictureModel.class);
//    }
//
//    @Override
//    public List<DoctorSelectViewModel> getAllSelect() {
//        List<Doctor> doctors = this.doctorRepository.findAllByOrderByFirstNameAscLastName();
//        List<DoctorSelectViewModel> doctorSelectViewModels = new ArrayList<>();
//        for (Doctor doctor : doctors) {
//            DoctorSelectViewModel doctorSelectViewModel = this.modelMapper.map(doctor, DoctorSelectViewModel.class);
//            doctorSelectViewModels.add(doctorSelectViewModel);
//        }
//
//        return doctorSelectViewModels;
//    }
//
//    @Override
//    public Doctor getByUserId(long userId) {
//        return this.doctorRepository.findOneByUserId(userId);
//    }
//
//
//    @Override
//    public EditDoctorModel getEditModelByUserId(long userId) {
//        Doctor doctor = this.doctorRepository.findOneByUserId(userId);
//
//        return this.modelMapper.map(doctor, EditDoctorModel.class);
//    }
//
//    @Override
//    public DoctorSelectViewModel getModelByUserId(long userId) {
//        Doctor doctor = this.doctorRepository.findOneByUserId(userId);
//
//        return this.modelMapper.map(doctor, DoctorSelectViewModel.class);
//    }
//
//    @Override
//    public Page<DoctorViewModel> getAll(Pageable pageable) {
//        Page<Doctor> doctors = this.doctorRepository.findAll(pageable);
//        List<DoctorViewModel> doctorViewModels = new ArrayList<>();
//        for (Doctor doctor : doctors) {
//            DoctorViewModel doctorViewModel = this.modelMapper.map(doctor, DoctorViewModel.class);
//            doctorViewModels.add(doctorViewModel);
//        }
//
//        return (Page<DoctorViewModel>) new PageImpl(doctorViewModels, pageable, doctors.getTotalElements());
//    }
//
//    private User createDoctorUser(DoctorRegistrationModel registrationModel) {
//        UserRegistrationModel userRegistrationModel = this.modelMapper.map(registrationModel, UserRegistrationModel.class);
//        String DEFAULT_DOCTOR_ROLE = "ROLE_DOCTOR";
//        userRegistrationModel.setAdditionalRole(DEFAULT_DOCTOR_ROLE);
//        return this.userService.register(userRegistrationModel);
//    }
}