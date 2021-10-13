import java.util.ArrayList;

public class ListDriver implements ListDriverInterface {

    @Override
    public ListInterface<Integer> createList(ListType listType, TestType forTestType) {
        ListInterface<Integer> list = null;
        if (listType== ListType.ArrayBasedList){
            list= new ArrayBasedList<Integer>();
        }
        else if(listType== ListType.LinkedList){
            list= new LinkedList<Integer>();
        }
        if (forTestType== TestType.AddSortedOdd || forTestType== TestType.AddAllAtIndexZero || forTestType== TestType.AddAll){
            return list;
        }
        if ( forTestType== TestType.RemoveAllEven || forTestType== TestType.RemoveAllOdd){
            return initializeList(list, 1, 10000, 1);
        }
        if (forTestType== TestType.AddSortedEven){
            return initializeList(list, 1, 9999, 2);
        }
        return list;
    }

    @Override
    public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber, int increment) {
        if (increment== 0){
            return list;
        }
        for (int item = firstNumber; item <= lastNumber; item+= increment) {
            list.add(item);
        }
        return list;
    }

    @Override
    public double memoryUsage() {
        Runtime r = Runtime.getRuntime();
        double memory= r.totalMemory()- r.freeMemory();
        memory= memory/1024;
        memory= memory/1024;
        //converting from byte to kilobyte, 1 KB= 1024B,
        // converting from kiloByte to megabyte. 1mB= 1024KB;
        return memory;
    }

    @Override
    public Object[] runTestCase(ListType listType, TestType testType, int numberOfTimes) {
        Object[] array= new Object[2*numberOfTimes+1];
        TestTimes tt= new TestTimes();
        for (int i = 0; i < numberOfTimes; i++) {
            ListInterface<Integer> list= createList(listType, testType);
            ListInterface<Integer> cpylist= list.copy();
            long startTime= System.nanoTime();
            if (testType== TestType.AddAll){
                for (int j = 1; j <= 10000; j++) {
                    list.add(j);
                }
            }
            if (testType == TestType.AddAllAtIndexZero){
                for (int j = 1; j <= 10000; j++) {
                    list.add(j, 0);
                }
            }
            if (testType== TestType.AddSortedEven){
                for (int j = 2; j <= 10000; j+=2) {
                    list.addSorted(j);
                }
            }
            if (testType== TestType.AddSortedOdd){
                for (int j = 1; j <=10000; j+=2) {
                    list.addSorted(j);
                }
            }
            if (testType== TestType.RemoveAllEven){
                for (int j = list.size()-1; j>=0 ; j-=2) {
                    list.remove(j);
                }
            }
            if (testType== TestType.RemoveAllOdd){
                for (int j = list.size()-2; j>=0 ; j-=2) {
                    list.remove(j);
                }
            }
            long endTime= System.nanoTime();
            long duration= endTime- startTime;
            tt.addTestTime(duration);
            if (listType== ListType.ArrayBasedList){
                array[2*i]= (ArrayBasedList<Integer>) cpylist;
                array[2*i+1]= (ArrayBasedList<Integer>)list;
            }
            if (listType== ListType.LinkedList){
                array[2*i]= (LinkedList<Integer>) cpylist;
                array[2*i+1]= (LinkedList<Integer>)list;
            }
        }
        array[numberOfTimes*2]= tt;
        return array;
    }
}
