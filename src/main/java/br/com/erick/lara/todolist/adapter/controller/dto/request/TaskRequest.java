package br.com.erick.lara.todolist.adapter.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskRequest {

    private String description;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT-3")
    private Date dateToFinish;

    public TaskRequest(String description, Date dateToFinish) {
        this.description = description;
        this.dateToFinish = dateToFinish;
    }

    public TaskRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateToFinish() {
        return dateToFinish;
    }

    public void setDateToFinish(Date dateToFinish) {
        this.dateToFinish = dateToFinish;
    }
}
