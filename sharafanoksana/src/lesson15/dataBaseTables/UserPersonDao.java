package lesson15.dataBaseTables;

import lesson15.entities.UserPerson;

public interface UserPersonDao {
    public boolean createUserTable();
    public boolean addUser(UserPerson person);
    public UserPerson getUserById(Integer id);
    public boolean updateUserById(UserPerson person);
    public boolean deleteUserById(Integer id);
}
