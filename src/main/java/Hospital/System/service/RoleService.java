package Hospital.System.service;

import Hospital.System.model.Role;

public interface RoleService {
    Role getDefaultRole();

    Role getRoleByAuthority(String authority);
}