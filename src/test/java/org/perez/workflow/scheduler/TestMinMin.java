package org.perez.workflow.scheduler;

import org.junit.Test;
import org.perez.workflow.elements.Resource;
import org.perez.workflow.elements.Task;
import org.perez.workflow.elements.Workflow;
import org.perez.workflow.scheduler.MinMin;
import org.perez.workflow.scheduler.Utils;

import java.util.ArrayList;

/**
 * Created by perez on 18/07/14.
 */
public class TestMinMin {
    @Test
    public void test1() {
        Task t1 = new Task("t1", 5);
        Task t2 = new Task("t2", 10);
        Task t3 = new Task("t3", 4);
        Task t4 = new Task("t4", 8);

        Workflow w = new Workflow();
        w.addTask(t1);
        w.addTask(t2);
        w.addTask(t3);
        w.addTask(t4);
        w.addDependency(t1,t2);
        w.addDependency(t1,t3);
        w.addDependency(t3,t4);
        w.addDependency(t2,t4);

        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(new Resource("r1", 5));
        resources.add(new Resource("r2", 10));

        System.out.println("MinMin");
        Utils.printSchedule(MinMin.schedule(w, resources));
    }

    @Test
    public void test2() {
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 10);
        Task t3 = new Task("t3", 10);
        Task t4 = new Task("t4", 10);

        Workflow w = new Workflow();
        w.addTask(t1);
        w.addTask(t2);
        w.addTask(t3);
        w.addTask(t4);
        w.addDependency(t1,t2);
        w.addDependency(t1,t3);
        w.addDependency(t3,t4);
        w.addDependency(t2,t4);

        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(new Resource("r1", 10));
        resources.add(new Resource("r2", 10));

        System.out.println("MinMin");
        Utils.printSchedule(MinMin.schedule(w, resources));
    }
}
