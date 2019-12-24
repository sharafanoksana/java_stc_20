package lesson15.dataBaseTables;

import lesson15.entities.UserPerson;

import java.util.Collection;

public interface UserPersonDao {
    public boolean addUser(UserPerson person);
    public UserPerson getUserById(Integer id);
    public boolean updateUserById(UserPerson person);
    public boolean deleteUserById(Integer id);

    Collection<UserPerson> getAllUserPerson();
}
