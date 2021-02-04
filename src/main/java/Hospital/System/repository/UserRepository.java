package Hospital.System.repository;

import Hospital.System.model.User;
import Hospital.System.model.bindingModel.ChangePasswordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

}