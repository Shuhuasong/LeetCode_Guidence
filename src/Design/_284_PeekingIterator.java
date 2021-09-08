package Design;

import java.util.Iterator;

/**
 * Created by Shuhua Song
 */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer peekedValue = null;
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
        if(peekedValue==null){
            if(!iter.hasNext()){
                // throw new NoSuchElementException();
                return null;
            }
            peekedValue = iter.next();
        }
        return peekedValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    /* Firstly, we need to check if we have a value already
     * stored in the peekedValue variable. If we do, we need to
     * return it and also set peekedValue to null so that the value
     * isn't returned again. */
    @Override
    public Integer next() {
        if(peekedValue != null){
            Integer results = peekedValue;
            peekedValue = null;
            return results;
        }
        /* As per the Java Iterator specs, we should throw a NoSuchElementException
         * if the next element doesn't exist. */
        if(!iter.hasNext()){
            return null;
            //throw new NoSuchElementException();
        }
        /* Otherwise, we need to return a new value. */
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        /* If there's a value waiting in peekedValue, or if there are values
         * remaining in the iterator, we should return true. */
        return peekedValue != null || iter.hasNext();
    }
}