package Design;

import java.util.Iterator;

/**
 * Created by Shuhua Song
 */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer peekedVal = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    /* If there's not already a peeked value, get one out and store
     * it in the peekedValue variable. We aren't told what to do if
     * the iterator is actually empty -- here I have thrown an exception
     * but in an interview you should definitely ask! This is the kind of
     * thing they expect you to ask about. */
    public Integer peek() {
        if(peekedVal != null){
            return peekedVal;
        }
        if(iter.hasNext()){
            peekedVal = iter.next();
        }
        return peekedVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    /* Firstly, we need to check if we have a value already
     * stored in the peekedValue variable. If we do, we need to
     * return it and also set peekedValue to null so that the value
     * isn't returned again. */
    @Override
    public Integer next() {
        if(peekedVal != null){
            Integer res = peekedVal;
            peekedVal = null;
            return res;
        }
        if(iter.hasNext()){
            return iter.next();
        }
        return peekedVal;
    }

    @Override
    public boolean hasNext() {
        /* If there's a value waiting in peekedValue, or if there are values
         * remaining in the iterator, we should return true. */
        return peekedVal != null || iter.hasNext();
    }

    /*

    Intuition
     Instead of only storing the next value after we've peeked at it, we can store it immediately in
     the constructor and then again in the next(...) method. This greatly simplifies the code,
      because we no longer need conditionals to check whether or not we are currently storing
      a peeked at value.
    Iterator<Integer> iter;
    Integer next = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if(iterator.hasNext()){
            next = iterator.next();
        }
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if(next != null){
            res = next;
            next = null;
        }
        if(iter.hasNext()){
            next = iter.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
     */


}