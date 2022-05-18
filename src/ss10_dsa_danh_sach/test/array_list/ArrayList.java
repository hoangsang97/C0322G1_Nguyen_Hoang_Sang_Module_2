package ss10_dsa_danh_sach.test.array_list;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] obj;

    public ArrayList(){
    }

    public ArrayList(int capacity) {
        if (capacity > 0) {
            obj = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity" + capacity);
        }
    }

    public void ensureCapacity(int miniCapacity) {
        if (miniCapacity >= 0) {
            int newSize = this.obj.length + miniCapacity;
            obj = Arrays.copyOf(obj, newSize);
            System.out.println("Khởi tạo mảng thành công : " + obj.length);
        } else {
            throw new IllegalArgumentException("miniCapaci" + miniCapacity);
        }
    }

    public void add(E e, int index) {
        if (index > obj.length) {
            throw new IllegalArgumentException("Lỗi index vượt quá mảng" + index);
        } else if (obj.length == index + 1) {
            ensureCapacity(1);
        }

        if (obj[index] == null) {
            size++;
            obj[index] = e;
        } else {
            if (size == obj.length){
                ensureCapacity(1);
            }
            System.arraycopy(obj, index, obj, index + 1, size -index);
            obj[index] = e;
            size++;
        }
    }

    public boolean add(E e) {
        if (size == obj.length) {
            ensureCapacity(1);
        }
        obj[size] = e;
        size++;
        return true;
    }

    public static void main(String[] args) {
        List<Person> arrayList = new java.util.ArrayList<>();

        arrayList.add(new Person("sang ", 10));
        arrayList.add(new Person("sang ", 10));
        arrayList.add(new Person("sang ", 10));
        arrayList.add(new Person("sang ", 10));
        arrayList.add(new Person("sang ", 10));
        arrayList.add(new Person("sang ", 10));

        System.out.println(arrayList.size());
        System.out.println(arrayList.get(4));
        System.out.println(Arrays.toString(arrayList.toArray()));

        System.out.println(arrayList.get(1).equals(arrayList.get(2)));
    }
}
