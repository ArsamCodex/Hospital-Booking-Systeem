package Hospital.System.serviceImpl;

import Hospital.System.repository.DoctorSpecialtyRepository;
import Hospital.System.service.DoctorSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorSpecialtyServiceImpl implements DoctorSpecialtyService {
    private DoctorSpecialtyRepository doctorSpecialtyRepository;

    @Autowired
    public DoctorSpecialtyServiceImpl(DoctorSpecialtyRepository doctorSpecialtyRepository) {
        this.doctorSpecialtyRepository = doctorSpecialtyRepository;
    }
}