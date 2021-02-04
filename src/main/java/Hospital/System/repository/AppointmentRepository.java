package Hospital.System.repository;

import Hospital.System.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("select a from Appointment as a where a.date between ?1 and ?2 and a.doctor.id = ?3")
    List<Appointment> findAllBetweenDatesByDoctorId( long doctorId);

    @Query("select a from Appointment as a where a.date between ?1 and ?2")
    List<Appointment> findAllBetweenDates(Date startDate, Date endDate);

    List<Appointment> findAllByPatientIdOrderByDate(long patientId);

    Page<Appointment> findAllByPatientIdOrderByDate(long patientId, Pageable pageable);

    List<Appointment> findAllByDoctorIdOrderByDate(long doctorId );

    Page<Appointment> findAllByDoctorIdOrderByDate(long doctorId, Pageable pageable);

    Appointment findOneByDateAndDoctorId(Date date, long doctorId);
}