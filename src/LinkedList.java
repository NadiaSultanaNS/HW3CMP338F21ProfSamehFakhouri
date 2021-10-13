public class LinkedList <I extends Comparable<? super I>> implements ListInterface<I>{
    LinkedListNode<I> head, tail;
    int length;

    public LinkedList(){
        head= null;
        tail= null;
        length= 0;
    }

    public ListInterface<I> copy() {
        LinkedList<I> linkedList= new LinkedList<>();
        LinkedListNode<I> curNode= head;
        while (curNode!= null){
            linkedList.add(curNode.getElement());
            curNode= curNode.getNext();
        }
        return linkedList;
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
        LinkedListNode<I> newNode= new LinkedListNode<>(element);
        if (head== null){
            head= newNode;
            tail= newNode;
        }
        else {
            tail.setNext(newNode);
            tail= newNode;
        }
        length++;
    }

    @Override
    public void add(I element, int index) throws IndexOutOfBoundsException {
        if (index>=length || index<0){
            throw new IndexOutOfBoundsException("Index too large");
        }
        else if(index== 0){
            LinkedListNode<I> newNode= new LinkedListNode<>(element);
            newNode.setNext(head);
            head= newNode;
        }
        else {
            LinkedListNode<I> newNode= new LinkedListNode<>(element);
            LinkedListNode<I> curNode= head;
            int skip= index-1;
            while (skip>0){
                curNode= curNode.getNext();
                skip--;
            }
            newNode.setNext(curNode.getNext());
            curNode.setNext(newNode);
        }
        length++;
    }

    @Override
    public void addSorted(I element) {
        if(head==null || tail.getElement().compareTo(element)<=0) {
            add(element);
        }
        else {
            int index= 0;
            LinkedListNode<I> curNode= head;
            while (curNode.getElement().compareTo(element)<0){
                index++;
                curNode= curNode.getNext();
            }
            add(element, index);
        }
    }

    @Override
    public I get(int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        LinkedListNode<I> curNode= head;
        while (index>0){
            curNode= curNode.getNext();
            index--;
        }
        return curNode.getElement();
    }

    @Override
    public I replace(I element, int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        LinkedListNode<I> curNode= head;
        while (index>0){
            curNode= curNode.getNext();
            index--;
        }
        I stored= curNode.getElement();
        curNode.setElement(element);
        return stored;
    }

    @Override
    public I remove(int index) throws IndexOutOfBoundsException {
        if (index>=length){
            throw new IndexOutOfBoundsException("Index too large");
        }
        length--;
        if (index== 0){
            I store= head.getElement();
            head= head.getNext();
            return store;
        }
        LinkedListNode<I> curNode= head;
        while (index>1){
            curNode= curNode.getNext();
            index--;
        }
        LinkedListNode<I> sucNode= curNode.getNext().getNext();
        if (sucNode== null){
            tail= curNode;
        }
        I stored= curNode.getNext().getElement();
        curNode.setNext(sucNode);
        return stored;
    }

    @Override
    public void removeAll() {
        head= null;
        tail= null;
        length= 0;
    }
}
