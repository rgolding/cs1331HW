import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Arrays;
import java.lang.Iterable;


/**
* This class implements the SimpleSet interface
*
* @param <T> Param Type
* @version 1.0
* @author _insert_name_
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    /* Implement methods here */


    public MySet() {
        backingArray = (T[]) new Object[10];
        numElements = 0;
    }
    public boolean add(T e) {
        if (e == null) {
            return false;
        }
        for (Object o : backingArray) {
            if (o != null) {
                if (o.equals(e)) {
                    return false;
                }
            }
        }
        if (numElements == backingArray.length) {
            backingArray = Arrays.copyOf(backingArray, backingArray.length + 10);
        }
        backingArray[numElements] = (T) e;

        numElements ++;
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {

        for (T e : c) {
            this.add(e);
        }
        return true;
    }
    public void clear() {
        T[] nArray = (T[]) new Object[backingArray.length];
        numElements = 0;
        backingArray = nArray;
    }
    public boolean contains(Object o) {
        for (T backingE : backingArray) {
            if (o != null && o.equals(backingE)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsAll(Collection<?> c) {
        for(Object e : c) {
            if(!this.contains(e)) {
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object o) {
        if (o instanceof Set && (((Set)o).size() == numElements)) {
            for (T elem : (Set<T>)o){
               if (this.contains(o) == false) {
                 return false;  
            }
            return true;
           }
        }
        return false;
    }
    public int hashCode() {
        int result = 0;
        for (T elem : backingArray){
            if (elem != null){
               result = result + elem.hashCode();
            }
        }
      return result;
    }
    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean remove(Object o) {
        int i = 0;
        for (Object e : backingArray) {
            if (o != null && o.equals(e)) {
                System.arraycopy(backingArray, i + 1, backingArray,
                    i, numElements - i - 1);
                backingArray[numElements - 1] = null;


                numElements = numElements - 1;
                T[] newArray=Arrays.copyOf(backingArray,backingArray.length-1);
                return true;
            }
            i ++;
        }
        return false;
    }






    public boolean removeAll(Collection<?> c) {
        for (Object e : c) {
            this.remove(e);

        }
        return true;
    }






    public boolean retainAll(Collection<?> c) {
        int i = 0;
        boolean check = false;
        if (this.containsAll(c)) {
            check = true;
        }

        while (i < numElements) {
            T e = backingArray[i];
            if (e != null && !(c.contains(e))) {
                this.remove(e);
            } else {
                i ++;
            }
        }
        return check;

    }





    public int size() {
        return numElements;
    }
    public Object[] toArray() {
        return backingArray;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }




    /*
    ----------------------------------------------
    These methods are provided to help you, DO NOT MODIFY!
    Refer to the slides on Iterators if you want to learn more
    http://cs1331.org/slides/iterators.pdf
    */

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

    }

}
