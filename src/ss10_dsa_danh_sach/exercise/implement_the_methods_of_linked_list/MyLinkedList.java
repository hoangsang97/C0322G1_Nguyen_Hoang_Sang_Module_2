package ss10_dsa_danh_sach.exercise.implement_the_methods_of_linked_list;

import java.util.Arrays;

public class MyLinkedList<E> {
    /**
     * Số lượng phần tử trong MyArrayList
     */
    private int size = 0;

    /**
     * Sức chứa mặc định trong MyArraylist
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * mảng đối tượng elements chứa các phần tử trong MyArrayList
     */
    private Object[] elements;


    /**
     * Phương thức khởi tạo không tham số;
     * mặc định khi khởi tạo sẽ tạo ra mảng object có kích thước là DEFAULT_CAPACITY
     */
    public void myLinkedList() {
        System.out.println("Khởi tạo thành công MyArrayList có kích thước là: " + DEFAULT_CAPACITY);
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phương thức khỏi tạo với kích thước mảng được truyền vào là tham số capacity
     *
     * @param capacity
     */
    public void MyArrayList(int capacity) {
        if (capacity > 0) {
            System.out.println("Khởi tạo thành công với kích thước là : " + capacity);
            elements = new Object[capacity];
        } else {
            System.out.println("Lỗi tham số truyền vào");
            throw new IllegalArgumentException("capacity : " + capacity);
        }
    }

    /**
     * Phương thức tăng kích thước của mảng chứa phần tử
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
            System.out.println("Khởi tạo thành công với kích thước là : " + elements.length);
        } else {
            throw new IllegalArgumentException("minCapacity : " + minCapacity);
        }
    }


    /**
     * Thêm phần tử vào vị trí index
     * @param e
     * @param index
     */
    public void add(E e, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("Lỗi index : " + index);
        } else if (elements.length == index +1) {
            ensureCapacity(1);
        }
        if (elements[index] == null){
            size++;
            elements[index] = e;
        }else {
            if (size == elements.length){
                ensureCapacity(1);
            }
            System.arraycopy(elements, index, elements, index + 1,
                    size - index);
            elements[index] = e;
            size++;
        }

    }

    /**
     * Phương thức thêm một phần tử vào cuối ArrayList
     */
    public boolean add(E e) {
        if (size == elements.length){
            ensureCapacity(1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    /**
     * Phương thức xoá phần tử tại vị trí index
     * @param index
     * @return
     */

    public E remove(int index){
        if (index<0 || index > elements.length){
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return element;
    }


    /**
     * Phương thức trả về số phần tử trong mảng
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * Phương thức trả về kích thước của MyArrayList
     * @return
     */

    public int length(){
        return elements.length;
    }

    /**
     * Phương thức clone 1 arrayList
     * @return
     */
    public MyLinkedList<E> clone(){
        MyLinkedList<E> v = new MyLinkedList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }


    /**
     * Phương thức trả về vị trí của 1 phần tử trong MyArraylist
     * @param e
     * @return
     */
    public int indexOf(E e){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * Phương thức trả về phần tử tại vị trí index
     * @param index
     * @return
     */
    public E get(int index){
        return (E) elements[index];
    }
    /**
     * Phương thức kiểm tra 1 phần tử có tồn tại trong MyArrayList hay không
     * @param e
     * @return
     */
    public boolean contains(E e){
        return this.indexOf(e) >= 0;
    }


    /**
     * phương thức xoá toàn bộ các phần tử trong MyArrayList
     */
    public void clear(){
        size = 0;
        for (int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
    }
}
