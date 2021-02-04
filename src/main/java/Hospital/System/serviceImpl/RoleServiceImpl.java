package Hospital.System.serviceImpl;

import Hospital.System.model.Role;
import Hospital.System.repository.RoleRepository;
import Hospital.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private static final String DEFAULT_ROLE = "ROLE_USER";

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getDefaultRole() {
        return this.roleRepository.findOneByAuthority(DEFAULT_ROLE);
    }

    @Override
    public Role getRoleByAuthority(String authority) {
        return this.roleRepository.findOneByAuthority(authority);
    }
}
