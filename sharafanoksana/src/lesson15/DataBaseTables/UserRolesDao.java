package lesson15.DataBaseTables;

import lesson15.Entities.RolePerson;
import lesson15.Entities.UserPerson;

public interface UserRolesDao {
    public boolean createUserRoleTable();
    public boolean addUserRoles(UserPerson userPerson, int id);
    public boolean updateIdRolesInUsersRoles(UserPerson userPerson, int id);
    public boolean deleteUsersRolesById(Integer id);
}
