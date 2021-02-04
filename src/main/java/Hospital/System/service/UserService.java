package Hospital.System.service;

import Hospital.System.model.User;
import Hospital.System.model.bindingModel.ChangePasswordModel;
import Hospital.System.model.bindingModel.UserRegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(UserRegistrationModel registrationModel);

    boolean updatePassword(ChangePasswordModel changePasswordModel);
}