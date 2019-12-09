package lesson15.DataBaseTables;

import lesson15.Entities.RolePerson;

public interface RoleDao {
    public boolean createRoleTable();
    public boolean addRole(RolePerson rolePerson);
    public RolePerson getRoleById(Integer id);
    public boolean updateRoleById(RolePerson person);
    public boolean deleteRoleById(Integer id);
}
