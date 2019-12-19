package lesson15.dataBaseTables;

import lesson15.entities.RolePerson;

public interface RoleDao {
    public boolean createRoleTable();
    public boolean addRole(RolePerson rolePerson);
    public RolePerson getRoleById(Integer id);
    public boolean updateRoleById(RolePerson person);
    public boolean deleteRoleById(Integer id);
}
