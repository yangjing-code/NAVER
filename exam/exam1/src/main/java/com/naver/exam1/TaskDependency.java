package com.naver.exam1;

public class TaskDependency {
    private final Task task;
    private final Task dependency;

    public TaskDependency(Task task, Task dependency) {
        this.task = task;
        this.dependency = dependency;
    }

    public Task getTask() {
        return task;
    }

    public Task getDependency() {
        return dependency;
    }
}
