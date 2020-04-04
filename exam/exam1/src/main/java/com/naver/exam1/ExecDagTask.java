package com.naver.exam1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ExecDagTask {
    private List<Task> taskMap;
    private List<TaskDependency> taskDependencies;

    public ExecDagTask() {
        taskMap = new ArrayList<Task>();
        taskDependencies = new ArrayList<TaskDependency>();
    }

    public void initTasksDependencies(Task task, Task dependencyTask) {
        TaskDependency taskDependency = new TaskDependency(task, dependencyTask);
        taskDependencies.add(taskDependency);
    }

    public void printTaskOrder(List<Task> tasks){
        List<TaskDependency> tmpTaskDependencies = new ArrayList<>();
        tmpTaskDependencies.addAll(taskDependencies);

        while (!tasks.isEmpty()) {
            List<Task> execTask = getTaskHasNoDependency(tasks, tmpTaskDependencies);

            execTask.stream().forEach(e->System.out.println("exec Task: "+ e.getTaskName()));

            removeDependency(execTask, tmpTaskDependencies);
        }

    }

    //if Task A is finish, if has task B dependency A, then remove this dependency data in taskDependencies
    private void removeDependency(List<Task> tasks, List<TaskDependency> taskDependencies) {
        Iterator<TaskDependency> iter = taskDependencies.iterator();

        while (iter.hasNext()) {
            TaskDependency taskDependency = iter.next();
            Optional<Task> find = tasks.stream().
                    filter(e->e.getTaskName().equals(taskDependency.getDependency().getTaskName())).findAny();
            if (find.isPresent()) {
                iter.remove();
            }
        }

    }

    private List<Task> getTaskHasNoDependency(List<Task> tasks, List<TaskDependency> taskDependencies) {
        Iterator<Task> iter = tasks.iterator();
        List<Task> findTask = new ArrayList<Task>();

        while (iter.hasNext()) {
            Task task = iter.next();

            Optional<TaskDependency> find = taskDependencies.stream().
                    filter(e->e.getTask().getTaskName().equals(task.getTaskName())).findAny();
            if (find.isPresent()) {
                //this task  has dependency task , wait dependency task finish;
                continue;
            }
            findTask.add(task);
            iter.remove();
        }

        return findTask;
    }
}
