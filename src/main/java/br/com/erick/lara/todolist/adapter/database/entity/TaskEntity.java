package br.com.erick.lara.todolist.adapter.database.entity;

import br.com.erick.lara.todolist.domain.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer id;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT-3")
    private Date dhInsert;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT-3")
    private Date dateToFinish;
    private boolean isFinished;
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

    public TaskEntity(Integer id, String description, Date dhInsert, Date dateToFinish, boolean isFinished, TaskStatusEnum status) {
        this.id = id;
        this.description = description;
        this.dhInsert = dhInsert;
        this.dateToFinish = dateToFinish;
        this.isFinished = isFinished;
        this.status = status;
    }

    public TaskEntity(String description, Date dateToFinish) {
        this.description = description;
        this.dhInsert = new Date();
        this.dateToFinish = dateToFinish;
        this.isFinished = false;
        this.status = TaskStatusEnum.ACTIVE;
    }

    public TaskEntity() {
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

    public boolean getFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
