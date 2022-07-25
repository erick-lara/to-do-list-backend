package br.com.erick.lara.todolist.domain.enums;

public enum TaskStatusEnum {
    ACTIVE,
    FINISHED;

    @Override
    public String toString() {
        return this.name();
    }
}
