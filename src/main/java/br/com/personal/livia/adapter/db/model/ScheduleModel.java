package br.com.personal.livia.adapter.db.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime dateTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORKOUT_ID", referencedColumnName = "id")
    private WorkOutModel workOutModel;
    private boolean isClientMiss;
    private boolean isClientRescheduled;
    private UUID clientId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public WorkOutModel getWorkOutModel() {
        return workOutModel;
    }

    public void setWorkOutModel(WorkOutModel workOutModel) {
        this.workOutModel = workOutModel;
    }

    public boolean isClientMiss() {
        return isClientMiss;
    }

    public void setClientMiss(boolean clientMiss) {
        isClientMiss = clientMiss;
    }

    public boolean isClientRescheduled() {
        return isClientRescheduled;
    }

    public void setClientRescheduled(boolean clientRescheduled) {
        isClientRescheduled = clientRescheduled;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
