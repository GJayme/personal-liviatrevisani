package br.com.personal.livia.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORKOUT_ID", referencedColumnName = "id")
    private WorkOutModel workOutModel;

    @ManyToMany
    @JoinTable(
            name = "SCHEDULE_CLIENT",
            joinColumns = @JoinColumn(name = "id_schedule"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private Set<ClientModel> clientModelSet;

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

    public Set<ClientModel> getClientModelSet() {
        return clientModelSet;
    }

    public void setClientModelSet(Set<ClientModel> clientModelSet) {
        this.clientModelSet = clientModelSet;
    }
}
