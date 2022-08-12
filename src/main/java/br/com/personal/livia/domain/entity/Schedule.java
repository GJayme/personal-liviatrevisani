package br.com.personal.livia.domain.entity;

import br.com.personal.livia.domain.exception.ScheduleException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Schedule {

    private LocalDateTime dateTime;
    private final UUID clientId;
    private boolean isClientMiss;
    private boolean isClientRescheduled;
    private Workout workout;

    public Schedule(LocalDateTime dateTime, UUID clientId, Workout workout) {
        //todo colocar validacao de campos obrigatorios
        this.dateTime = dateTime;
        this.clientId = clientId;
        this.isClientMiss = false;
        this.isClientRescheduled = false;
        this.workout = workout;
    }

    public void setClientMiss() {
        isClientMiss = true;
    }

    public void setClientRescheduled() {
        if (!isClientMiss) {
            throw new ScheduleException("Client don't miss these Schedule. For client reschedule, first need to miss the original schedule.");
        }
        isClientRescheduled = true;
    }

    public void setDateTime(LocalDateTime localDateTime) {
        if (localDateTime.isBefore(LocalDateTime.now())) {
            throw new ScheduleException("Invalid date and time for schedule.");
        }
        dateTime = localDateTime;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return isClientMiss == schedule.isClientMiss && isClientRescheduled == schedule.isClientRescheduled && Objects.equals(dateTime, schedule.dateTime) && Objects.equals(clientId, schedule.clientId) && Objects.equals(workout, schedule.workout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, clientId, isClientMiss, isClientRescheduled, workout);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "dateTime=" + dateTime +
                ", clientId=" + clientId +
                ", isClientMiss=" + isClientMiss +
                ", isClientRescheduled=" + isClientRescheduled +
                ", workout=" + workout +
                '}';
    }
}
