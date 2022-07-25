package br.com.erick.lara.todolist.domain;

import br.com.erick.lara.todolist.domain.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Task {
    private Integer id;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT-3")
    private Date dhInsert;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT-3")
    private Date dateToFinish;
    private Boolean isFinished;
    private TaskStatusEnum status;

    public Task(Integer id, String description, Date dhInsert, Date dateToFinish, Boolean isFinished, TaskStatusEnum status) {
        this.id = id;
        this.description = description;
        this.dhInsert = dhInsert;
        this.dateToFinish = dateToFinish;
        this.isFinished = isFinished;
        this.status = status;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDhInsert() {
        return dhInsert;
    }

    public void setDhInsert(Date dhInsert) {
        this.dhInsert = dhInsert;
    }

    public Date getDateToFinish() {
        return dateToFinish;
    }

    public void setDateToFinish(Date dateToFinish) {
        this.dateToFinish = dateToFinish;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
