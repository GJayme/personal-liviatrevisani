package br.com.personal.livia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "CLIENT")
public class ClientModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 130)
    private String name;

    @Column(nullable = false, length = 1)
    private Character gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false, length = 11)
    private String celPhone;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(unique = true, length = 130)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @ManyToMany(mappedBy = "clientModelSet")
    private Set<ScheduleModel> scheduleModelSet;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celphone) {
        this.celPhone = celphone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<ScheduleModel> getScheduleModelSet() {
        return scheduleModelSet;
    }

    public void setScheduleModelSet(Set<ScheduleModel> scheduleModelSet) {
        this.scheduleModelSet = scheduleModelSet;
    }
}
