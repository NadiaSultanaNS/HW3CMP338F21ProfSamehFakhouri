public class ArrayBasedList<I extends Comparable<? super I>> implements ListInterface<I> {

    Object[] array;
    int allocSize, length;

    public ArrayBasedList(){
        allocSize= 8;
        length= 0;
        array= new Object[allocSize];
    }

    @Override
    public ListInterface<I> copy() {
        ArrayBasedList<I> temp= new ArrayBasedList<>();
        for (int i = 0; i < length; i++) {
            temp.add((I)array[i]);
        }
        return temp;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return (length== 0);
    }

    @Override
    public void add(I element) {
        if (length>= allocSize){
            allocateSize();
        }
        array[length]= element;
        length++;
    }

    @Override
    public void add(I element, int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index doesn't exist");
        }
        if(length>=allocSize){
            allocateSize();
        }
        for (int i = length-1; i >=index; i--) {
            array[i+1]= array[i];
        }
        array[index]= element;
        length++;
    }

    @Override
    public void addSorted(I element) {
        if (length==0 || ((I)array[length-1]).compareTo(element)<=0){
            add(element);
            return;
        }
        // binary search to find the smallest item bigger than element.
        int low=0, high=length-1;
        while (low<high){
            int mid= (low+high)/2;
            if (element.compareTo((I)array[mid])>0){
                low= mid+1;
            }
            else {
                high= mid;
            }
        }
        add(element,low);

    }

    @Override
    public I get(int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        return (I)array[index];
    }

    @Override
    public I replace(I element, int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        if (array[index]== null){
            return null;
        }
        I store= (I) array[index];
        array[index]= element;
        return store;
    }

    @Override
    public I remove(int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        I store= (I) array[index];
        for (int i = index; i <length-1; i++) {
            array[i]= array[i+1];
        }
        length--;
        return store;
    }

    @Override
    public void removeAll() {
            length=0;
    }

    public void allocateSize(){
        allocSize*=2;
        Object[] temp= new Object[allocSize];
        for (int i = 0; i < length; i++) {
            temp[i]= array[i];
        }
        array= temp;
    }

    public static void main(String[] args) {
        ArrayBasedList <Integer> arrayBasedList= new ArrayBasedList();
        arrayBasedList.addSorted(25);
        arrayBasedList.addSorted(13);
        arrayBasedList.addSorted(60);
        arrayBasedList.addSorted(50);
        arrayBasedList.addSorted(80);
        arrayBasedList.addSorted(70);
        arrayBasedList.addSorted(65);
        arrayBasedList.addSorted(100);
        arrayBasedList.addSorted(90);
        arrayBasedList.addSorted(10);
        arrayBasedList.addSorted(0);
        arrayBasedList.remove(1);
        for (int i = 0; i < arrayBasedList.size() ; i++) {
            System.out.println(arrayBasedList.get(i));
        }
        ArrayBasedList<Integer> copylist= (ArrayBasedList<Integer>) arrayBasedList.copy();
        for (int i = 0; i < copylist.size() ; i++) {
            System.out.println(copylist.get(i));
        }

    }

}
