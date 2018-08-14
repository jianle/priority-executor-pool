package com.tutorial.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by jianle on 18-8-13.
 */
public class PriorityFutureTask<V>
        extends FutureTask<V> implements Comparable<PriorityFutureTask<V>> {

    private Object object;

    public PriorityFutureTask(Callable<V> callable) {
        super(callable);
        object = callable;
    }

    public PriorityFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        object = runnable;
    }

    @Override
    public int compareTo(PriorityFutureTask<V> o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return -1; // high priority
        }
        if (object != null && o.object != null) {
            if ((object instanceof Comparable)) {
                return ((Comparable) object).compareTo(o.object);
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof PriorityFutureTask)) {
            return false;
        } else {
            PriorityFutureTask<V> c = (PriorityFutureTask<V>) obj;
            return object.equals(c.object);
        }
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
