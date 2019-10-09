package com.architectured.notifications.controllers;

import com.architectured.notifications.models.Notification;
import com.architectured.notifications.repositiories.NotificationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Notification> getAllNotifications() {
        System.out.println("Hola prros");
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Notification getNotificationById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyNotificationById(@PathVariable("id") ObjectId id, @Valid @RequestBody Notification pets) {
        pets.set_id(id);
        repository.save(pets);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Notification createNotification(@Valid @RequestBody Notification pets) {
        pets.set_id(ObjectId.get());
        repository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }


    @RequestMapping(value = "/toUser/{id}", method = RequestMethod.GET)
    public List<Notification> getByToUser(@PathVariable String id){
        return  repository.findByToUserId(id);
    }

    @RequestMapping(value = "/fromUser/{id}", method = RequestMethod.GET)
    public List<Notification> getByFromUser(@PathVariable String id){
        return  repository.findByFromUserId(id);
    }

    @RequestMapping(value = "/toUserAndStatus/{toUserId}/{status}", method = RequestMethod.GET)
    public List<Notification> findByToUserIdAndStatus(@PathVariable String toUserId,@PathVariable String status){
        System.out.println(toUserId + status);
        return  repository.findByToUserIdAndStatus(toUserId,status);
    }

    @RequestMapping(value = "/fromUserAndStatus/{fromUserId}/{status}", method = RequestMethod.GET)
    public List<Notification> findByFromUserIdAndStatus(@PathVariable String fromUserId,@PathVariable String status){
        System.out.println(fromUserId + status);
        return  repository.findByFromUserIdAndStatus(fromUserId,status);
    }


}
