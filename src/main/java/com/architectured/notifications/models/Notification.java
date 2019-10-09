package com.architectured.notifications.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Notification {
    @Id
    public ObjectId _id;

    public String type;
    public String description;
    public String toUserId;
    public String fromUserId;
    public Date creationDate;
    public String status;

    public Notification(ObjectId _id, String type, String description, String toUserId, String fromUserId, Date creationDate, String status) {
        this._id = _id;
        this.type = type;
        this.description = description;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.creationDate = creationDate;
        this.status = status;
    }

    // ObjectId needs to be converted to string
    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // Constructors
    public Notification() {
    }


}
