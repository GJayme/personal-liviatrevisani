package br.com.personal.livia.adapter.dto;

public class SubscriptionDto {

    private String clientId;
    private Integer workoutQuantityAvailable;
    private Double valueHour;
    private String yearMonthReference;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getWorkoutQuantityAvailable() {
        return workoutQuantityAvailable;
    }

    public void setWorkoutQuantityAvailable(Integer workoutQuantityAvailable) {
        this.workoutQuantityAvailable = workoutQuantityAvailable;
    }

    public Double getValueHour() {
        return valueHour;
    }

    public void setValueHour(Double valueHour) {
        this.valueHour = valueHour;
    }

    public String getYearMonthReference() {
        return yearMonthReference;
    }

    public void setYearMonthReference(String yearMonthReference) {
        this.yearMonthReference = yearMonthReference;
    }
}
