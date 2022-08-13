package br.com.personal.livia.adapter.db.mapper;

import br.com.personal.livia.adapter.db.model.SubscriptionModel;
import br.com.personal.livia.adapter.dto.SubscriptionDto;
import br.com.personal.livia.domain.entity.Subscription;

import java.time.YearMonth;
import java.util.UUID;

public interface SubscriptionMapper {

     static SubscriptionModel toEntity(Subscription subscription) {
        var subscriptionModel = new SubscriptionModel();
        subscriptionModel.setClientId(subscription.getClientId());
        subscriptionModel.setWorkoutQuantityAvailable(subscription.getWorkoutQuantityAvailable());
        subscriptionModel.setWorkoutQuantityFinished(subscription.getWorkoutQuantityFinished());
        subscriptionModel.setValueHour(subscription.getValueHour());
        subscriptionModel.setExpire(subscription.getExpire());
        subscriptionModel.setYearMonthReference(subscription.getYearMonthReference().toString());
        subscriptionModel.setCreateDate(subscription.getCreateDate());
        subscriptionModel.setUpdateDate(subscription.getUpdateDate());
        return subscriptionModel;
    }

    static Subscription toSubscription(SubscriptionDto subscriptionDto) {
        return new Subscription.SubscriptionBuilder()
                .setClientId(UUID.fromString(subscriptionDto.getClientId()))
                .setWorkoutQuantityAvailable(subscriptionDto.getWorkoutQuantityAvailable())
                .setValueHour(subscriptionDto.getValueHour())
                .setYearMonthReference(YearMonth.parse(subscriptionDto.getYearMonthReference()))
                .build();
    }
}
