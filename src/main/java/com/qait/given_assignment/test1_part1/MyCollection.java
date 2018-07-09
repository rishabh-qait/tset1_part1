package com.qait.given_assignment.test1_part1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
    
    /**
     * You can declare local/global variables as per your requirement
     */
    @SuppressWarnings("unused")
    private int[] numArray;
    /**
     * It constructs an empty Collection object with an array capacity specified by the integer
        parameter "arraySize".
     */
    public MyCollection(int arraySize){
        numArray = new int[arraySize];
    }

    public int search(int searchingNum) {
        int position=-1;
        for(int i=0;i<NumberOfElementsPresent();i++) {
            if(numArray[i]==searchingNum) {
                position = i;
                break;
            }
        }
        return position;
    }

    public boolean add(int numberToAdd) {
        
        int size = NumberOfElementsPresent();
    
        if(size!=numArray.length&&search(numberToAdd)==-1) {
            numArray[size]=numberToAdd;
            return true;
        }
        else if(size==numArray.length) {
            doubleCapacity();
            size = NumberOfElementsPresent();
            numArray[size]=numberToAdd;
            return true;
        }
        
        
        return false;
    }

    public void doubleCapacity() {
        int[] double_array = new int[numArray.length*2];
        for(int i=0;i<numArray.length;i++) {
            double_array[i] = numArray[i];
        }
        numArray = double_array;
    }

    public boolean remove(int numberToRemove) {
        int position=search(numberToRemove);
        if(position!=-1) {
        for(int i=position;i<NumberOfElementsPresent()-1;i++) {
            numArray[i]=numArray[i+1];
        }
        numArray[NumberOfElementsPresent()-1]=0;
        return true;
        }
        return false;
    }

    public int getCount() {
        return NumberOfElementsPresent();
    }

    public int[] rotate(int n) {
        int[] dummy_array =new int[n];
        
        for(int i=0;i<n;i++) {
            dummy_array[i]=numArray[i];
        }
        for(int i=n;i<NumberOfElementsPresent();i++) {
            numArray[i-n]=numArray[i];
        }
        for(int i=0;i<n;i++) {
            numArray[NumberOfElementsPresent()-n+i]=dummy_array[i];
        }
        
        
        return null;
    }
    
    public String toString() {
        String array="{";
        for(int i=0;i<NumberOfElementsPresent();i++) {
            array=array+Integer.toString(numArray[i])+",";
        }
        if(array.charAt(array.length()-1)==',') {
            array=array.substring(0, array.length()-1);
        }
        array=array+"}";
        return array;
    }
    
    private int NumberOfElementsPresent() {
        int count=0;
        for(int i=0;i<numArray.length;i++) {
            if(numArray[i]!=0)
                count++;
        }
        return count;
    }
    

}