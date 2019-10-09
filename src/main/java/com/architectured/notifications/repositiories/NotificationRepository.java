package com.architectured.notifications.repositiories;

import com.architectured.notifications.models.Notification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    Notification findBy_id(ObjectId _id);

    @Query("{ 'toUserId' : ?0 }")
    List<Notification> findByToUserId(String toUserId);

    @Query("{ 'fromUserId' : ?0 }")
    List<Notification> findByFromUserId(String fromUserId);

    @Query("{ 'toUserId' : ?0, 'status' : ?1 }")
    List<Notification> findByToUserIdAndStatus(String fromUserId, String status);

    @Query("{ 'fromUserId' : ?0, 'status' : ?1 }")
    List<Notification> findByFromUserIdAndStatus(String fromUserId, String status);

}
