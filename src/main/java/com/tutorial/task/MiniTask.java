package com.tutorial.task;

import com.tutorial.model.Mini;
import com.tutorial.queue.PriorityFutureTask;

/**
 * Created by jianle on 18-8-14.
 */
public class MiniTask extends AbstractTask<Integer> implements Runnable, Comparable {

    private Mini mini;

    public MiniTask(Mini mini) {
        this.mini = mini;
        this.priority = 1;
    }
    public MiniTask(Mini mini, Integer priority) {
        this.mini = mini;
        this.priority = priority;
    }

    public void run() {
        //to do
        System.out.println("Running - [" + mini.getMessage() + "], priority is [" + priority + "]" + " --- " + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        return mini.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof PriorityFutureTask) {
            PriorityFutureTask p = (PriorityFutureTask) obj;
            return this.equals(p.getObject());
        } else if (obj instanceof MiniTask) {
            MiniTask t = (MiniTask) obj;
            return mini.equals(t.mini);
        }
        return false;
    }

    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        } else if (!(o instanceof MiniTask)) {
            return -1;
        }
        MiniTask m = (MiniTask) o;
        return Integer.compare(priority, m.priority);
    }
}
