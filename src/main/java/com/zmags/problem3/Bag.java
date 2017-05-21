package com.zmags.problem3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ben on 21-05-2017.
 */

/*
* Ordered Collection which support all the operation defined in Collection interface.
* Collection Supports duplicate equal elements
* Collection can be used to store,remove and access  elements of genetic type E
*
* @param <E> the type of elements in this list
* */
public class Bag<E> implements Collection<E> {

    private List<E> internalList;

    public Bag() {
        internalList=new ArrayList<E>();
    }

    @Override
    public boolean add(E e) {
        return internalList.add(e);
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return internalList.iterator();
    }

    @Override
    public Object[] toArray() {
        return internalList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalList.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return internalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return internalList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return internalList.retainAll(c);
    }

    @Override
    public void clear() {
            internalList.clear();
    }
}
