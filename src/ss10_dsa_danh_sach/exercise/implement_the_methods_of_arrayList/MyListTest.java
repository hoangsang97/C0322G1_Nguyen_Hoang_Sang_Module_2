package ss10_dsa_danh_sach.exercise.implement_the_methods_of_arrayList;

public class MyListTest {
    static class Person {
        String name;
        int Age;

        Person(String name, int age) {
            this.name = name;
            Age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", Age=" + Age +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            return this.name.equals(((MyListTest.Person) obj).name)
                    && this.Age == ((MyListTest.Person) obj).Age;
        }
    }

    public static void main(String[] args) {
        MyList<MyListTest.Person> myList = new MyList<>(1);
        myList.ensureCapacity(3);
        myList.add(new MyListTest.Person("Nguyễn Văn A ", 30));
        myList.add(new MyListTest.Person("Nguyễn Văn B ", 30));
        myList.add(new MyListTest.Person("Nguyễn Văn C ", 30));
        myList.add(new MyListTest.Person("Nguyễn Văn D ", 30), 2);
        MyList<MyListTest.Person> list2 = myList.clone();
        int index = list2.indexOf(new MyListTest.Person("Nguyễn Văn C ", 39));
        System.out.println("index = " + index);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
    }
}
