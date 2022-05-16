package ss10_dsa_danh_sach.exercise.implement_the_methods_of_linked_list;

public class MyLinkedListTest {
    static class Person{
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
//            Person person = (Person) obj;
            return this.name.equals(((Person) obj).name)
                    && this.Age == ((Person) obj).Age;
        }
    }
    public static void main(String[] args) {
        MyLinkedList<Person> myLinkedList = new MyLinkedList<>();
        myLinkedList.ensureCapacity(4);
        myLinkedList.add(new Person("Nguyễn Văn A ", 30));
        myLinkedList.add(new Person("Nguyễn Văn B ", 30));
        myLinkedList.add(new Person("Nguyễn Văn C ", 30));
        myLinkedList.add(new Person("Nguyễn Văn D ", 30),1);
        MyLinkedList<Person> list2 = myLinkedList.clone();
        int index = list2.indexOf(new Person("Nguyễn Văn C ", 30));
        System.out.println("index = " + index);
        for (int i = 0; i < list2.size(); i++ ){
            System.out.println(myLinkedList.get(i).toString());
        }
    }
}
