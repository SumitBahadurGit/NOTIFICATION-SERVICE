package com.nepCafe.notification.repo;

import com.nepCafe.notification.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository< NotificationEntity, Long> {

    @Query
    List<NotificationEntity> findByUserId(String userId);

    @Query
    List<NotificationEntity> findByUserIdAndAction(String userId, String action);

}
