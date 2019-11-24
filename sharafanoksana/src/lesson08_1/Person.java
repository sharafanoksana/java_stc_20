/**
 * @author Sharafan Oksana
 * @date 23.11.2019
 * @package lesson08_1
 */
package lesson08_1;

import java.io.Serializable;

class PersonProxy
        implements java.io.Serializable
{
    public PersonProxy(Person orig)
    {
        data = orig.getFirstName() + "," + orig.getLastName() + "," + orig.getAge();
        if (orig.getSpouse() != null)
        {
            Person spouse = orig.getSpouse();
            data = data + "," + spouse.getFirstName() + "," + spouse.getLastName() + ","
                    + spouse.getAge();
        }
    }

    public String data;
    private Object readResolve()
            throws java.io.ObjectStreamException
    {
        String[] pieces = data.split(",");
        Person result = new Person(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
        if (pieces.length > 3)
        {
            result.setSpouse(new Person(pieces[3], pieces[4], Integer.parseInt
                    (pieces[5])));
            result.getSpouse().setSpouse(result);
        }
        return result;
    }
}

public class Person implements Serializable {
    public Person(String fn, String ln, int a)
    {
        this.firstName = fn; this.lastName = ln; this.age = a;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public Person getSpouse() { return spouse; }

    private void readObject(java.io.ObjectInputStream ois)
            throws java.io.IOException, ClassNotFoundException
    {
        java.io.ObjectInputStream.GetField fields = ois.readFields();
        firstName = (String)fields.get("firstName", "(Nobody)");
        lastName = (String)fields.get("lastName", "(Nobody)");
        age = fields.get("age", 0);
        spouse = (Person)fields.get("spouse", (Person)null);
    }

    private void writeObject(java.io.ObjectOutputStream oos)
            throws java.io.IOException
    {
        java.io.ObjectOutputStream.PutField fields = oos.putFields();
        fields.put("firstName", firstName);
        fields.put("lastName", lastName);
        fields.put("age", age);
        fields.put("spouse", spouse);
        oos.writeFields();
    }

    public void setFirstName(String value) { firstName = value; }
    public void setLastName(String value) { lastName = value; }
    public void setAge(int value) { age = value; }
    public void setSpouse(Person value) { spouse = value; }

    public String toString()
    {
        return "[Person: firstName=" + firstName +
                " lastName=" + lastName +
                " age=" + age +
                " spouse=" + spouse.getFirstName() +
                "]";
    }

    private String firstName;
    private String lastName;
    private int age;
    private Person spouse;
}
