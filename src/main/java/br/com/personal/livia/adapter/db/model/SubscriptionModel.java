package br.com.personal.livia.adapter.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.UUID;

@Entity
@Table(name = "SUBSCRIPTION")
public class SubscriptionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID clientId;
    private Integer workoutQuantityAvailable;
    private Integer workoutQuantityFinished;
    private Double valueHour;
    private Boolean expire;
    private String yearMonthReference;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public Integer getWorkoutQuantityAvailable() {
        return workoutQuantityAvailable;
    }

    public void setWorkoutQuantityAvailable(Integer workoutQuantityAvailable) {
        this.workoutQuantityAvailable = workoutQuantityAvailable;
    }

    public Integer getWorkoutQuantityFinished() {
        return workoutQuantityFinished;
    }

    public void setWorkoutQuantityFinished(Integer workoutQuantityFinished) {
        this.workoutQuantityFinished = workoutQuantityFinished;
    }

    public Double getValueHour() {
        return valueHour;
    }

    public void setValueHour(Double valueHour) {
        this.valueHour = valueHour;
    }

    public Boolean getExpire() {
        return expire;
    }

    public void setExpire(Boolean expire) {
        this.expire = expire;
    }

    public String getYearMonthReference() {
        return yearMonthReference;
    }

    public void setYearMonthReference(String yearMonthReference) {
        this.yearMonthReference = yearMonthReference;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
