package br.com.personal.livia.domain.entity;

import br.com.personal.livia.domain.exception.SubscriptionException;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Objects;
import java.util.UUID;

public class Subscription {

    private final UUID clientId;
    private final Integer workoutQuantityAvailable;
    private Integer workoutQuantityFinished;
    private final Double valueHour;
    private Boolean expire;
    private final YearMonth yearMonthReference;
    private final LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Subscription(UUID clientId, Integer workoutQuantityAvailable, Double valueHour, YearMonth yearMonthReference) {
        validOrThrow(clientId == null, "Client id doesn't be null.");
        this.clientId = clientId;

        validOrThrow(workoutQuantityAvailable == null, "Workout quantity available doesn't be null.");
        this.workoutQuantityAvailable = workoutQuantityAvailable;

        validOrThrow(valueHour == null, "Value hour doesn't be null.");
        this.valueHour = valueHour;

        validOrThrow(yearMonthReference == null, "Year Month Reference  doesn't be null.");
        this.yearMonthReference = yearMonthReference;

        this.workoutQuantityFinished = 0;

        this.expire = false;

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        this.createDate = localDateTime;
        this.updateDate = localDateTime;
    }

    public UUID getClientId() {
        return clientId;
    }

    public Integer getWorkoutQuantityAvailable() {
        return workoutQuantityAvailable;
    }

    public Integer getWorkoutQuantityFinished() {
        return workoutQuantityFinished;
    }

    public Double getValueHour() {
        return valueHour;
    }

    public Boolean getExpire() {
        return expire;
    }

    public YearMonth getYearMonthReference() {
        return yearMonthReference;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    private void validOrThrow(boolean field, String message) {
        if (field) {
            throw new SubscriptionException(message);
        }
    }

    private void setToExpire() {
        this.expire = true;
    }

    public void incrementWorkoutFinished() {
        this.workoutQuantityFinished++;
        this.updateDate = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public boolean isExpire() {
        if (workoutQuantityFinished.equals(workoutQuantityAvailable)) {
            setToExpire();
            this.updateDate = LocalDateTime.now(ZoneId.of("UTC"));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(workoutQuantityAvailable, that.workoutQuantityAvailable) && Objects.equals(workoutQuantityFinished, that.workoutQuantityFinished) && Objects.equals(valueHour, that.valueHour) && Objects.equals(expire, that.expire) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, workoutQuantityAvailable, workoutQuantityFinished, valueHour, expire, createDate, updateDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "clientId=" + clientId +
                ", workoutQuantityAvailable=" + workoutQuantityAvailable +
                ", workoutQuantityFinished=" + workoutQuantityFinished +
                ", valueHour=" + valueHour +
                ", expire=" + expire +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public static class SubscriptionBuilder {
        private UUID clientId;
        private Integer workoutQuantityAvailable;
        private Integer workoutQuantityFinished;
        private Double valueHour;
        private Boolean expire;
        private YearMonth yearMonthReference;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;

        public SubscriptionBuilder setClientId(UUID clientId) {
            this.clientId = clientId;
            return this;
        }

        public SubscriptionBuilder setWorkoutQuantityAvailable(Integer workoutQuantityAvailable) {
            this.workoutQuantityAvailable = workoutQuantityAvailable;
            return this;
        }

        public SubscriptionBuilder setValueHour(Double valueHour) {
            this.valueHour = valueHour;
            return this;
        }

        public SubscriptionBuilder setYearMonthReference(YearMonth yearMonthReference) {
            this.yearMonthReference = yearMonthReference;
            return this;
        }

        public Subscription build() {
            return new Subscription(clientId, workoutQuantityAvailable, valueHour, yearMonthReference);
        }
    }
}
