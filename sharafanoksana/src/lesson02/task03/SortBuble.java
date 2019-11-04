/**
 * @author Sharafan Oksana
 * @date 03.11.2019
 * @package lesson02.task03
 */
package lesson02.task03;

public class SortBuble implements Sortable {
    private Person[] people;

    public SortBuble(Person[] people) {
        this.people = people;
    }

    //Отсортируем массив строк через пузырьковую сортировку по полу.
    @Override
    public void sort() throws Exception {
        sortSex(people);
        for (int j = 0; j < people.length; j++) {
            for (int i = j + 1; i < people.length; i++) {
                switch (people[i].getSex()) {
                    case MAN:
                        if (people[i].getName().compareTo(people[j].getName()) != 0) {
                            toSwap(j, i);
                        } else if (people[i].getAge() != people[i + 1].getAge()) {
                            toSwap(i, i + 1);
                        }

                        break;
                    case WOMAN:
                        if(people[i].getAge() != people[i + 1].getAge()){
                            toSwap(i,i+1);
                        }
                        else if (people[i].getName().compareTo(people[j].getName()) < 0){
                            toSwap(j, i);
                        }
                        break;
                }
            }
            System.out.println(people[j].toString());
        }
    }

    public Person[] sortAge(Person[] people) {
        for (int j = people.length-1; j >=1; j--) {
            for (int i = 0; i < j; i++) {
                if(people[i].getAge() < people[i+1].getAge()){
                    toSwap(i, i+1);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    public Person[] sortName (Person [] people){
        for (int j = 0; j < people.length; j++) {
            for (int i = j + 1; i < people.length; i++) {
                if (people[i].getName().compareTo(people[j].getName()) < 0) {
                    toSwap(j, i);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    public Person[] sortSex(Person[] people) {
        for (int j = 0; j < people.length; j++) {
            for (int i = j + 1; i < people.length; i++) {
                if (people[i].getSex() == Sex.MAN) {
                    toSwap(j,i);
                }
            }
            System.out.println(people[j].toString());
        }
        return people;
    }

    private void toSwap(int first, int second){
        Person temp = people[first];
        people[first] = people[second];
        people[second] = temp;
    }
}


/**
 * //        for (int j = people.length-1; j >=1; j--) {
 * //            for (int i = 0; i < j; i++) {
 * ////                sortByName.compare(people[i].getName(people[i]), people[i].getName(people[i]));
 * //
 * //                if(people[i].getName().compareTo(people[i+1].getName() == -1)
 * //                {
 * ////                    Arrays.sort(people);
 * //                    toSwap(i, i+1);
 * //                }
 * ////                else if (people[i].getName(people[i]).compareTo(people[i+1].getName(people[i+1])) ==1){
 * ////                    toSwap(i+1, i);
 * ////                }
 * //            }
 * //            System.out.println(people[j].getName()+" "+ people[j].getAge()+" "+ people[j].getSex());
 * //        }
 * //
 * //        Arrays.sort(people, new SortByName());
 * //        for (int j = 0; j<people.length; j++) {
 * //            System.out.println(people[j].getName(people[j]));
 * //        }
 */


