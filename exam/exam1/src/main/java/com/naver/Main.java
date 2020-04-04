package com.naver;

import java.util.ArrayList;
import java.util.List;

import com.naver.exam1.ExecDagTask;
import com.naver.exam1.Task;

public class Main {
    public static void main(String[] args) {

        ExecDagTask execDagTask = new ExecDagTask();

        Task taska = new Task("task A");
        Task taskb = new Task("task B");
        Task taskc = new Task("task C");
        Task taskd = new Task("task D");
        Task taske = new Task("task E");
        Task taskf = new Task("task F");
        Task taskg = new Task("task G");
        Task taskh = new Task("task H");
        execDagTask.initTasksDependencies(taska, taskc);
        execDagTask.initTasksDependencies(taska, taskg);
        execDagTask.initTasksDependencies(taskc, taskh);
        execDagTask.initTasksDependencies(taskg, taskb);
        execDagTask.initTasksDependencies(taske, taskg);
        execDagTask.initTasksDependencies(taske, taskb);
        execDagTask.initTasksDependencies(taskd, taska);
        execDagTask.initTasksDependencies(taskf, taskd);
        execDagTask.initTasksDependencies(taskf, taske);


        List<Task> tasks = new ArrayList<>();
        tasks.add(taska);
        tasks.add(taskb);
        tasks.add(taskc);
        tasks.add(taskd);
        tasks.add(taske);
        tasks.add(taskf);
        tasks.add(taskg);
        tasks.add(taskh);
        execDagTask.printTaskOrder(tasks);

    }
}
