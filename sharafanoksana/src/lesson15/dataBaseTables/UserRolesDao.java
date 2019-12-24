package lesson15.dataBaseTables;

import lesson15.entities.UserPerson;

public interface UserRolesDao {
    public boolean addUserRoles(UserPerson userPerson, int id);
    public boolean updateIdRolesInUsersRoles(UserPerson userPerson, int id);
    public boolean deleteUsersRolesById(Integer id);
    public boolean selectIdRolesInUsersRoles(UserPerson userPerson);
    public UserPerson getIdRolesInUsersRoles(int id);
}
