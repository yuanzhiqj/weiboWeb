package com.example.demo.Controller;

import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@RestController
public class controller {
    List<User> userList = new ArrayList<>();
    User tempUser1 = new User(1,"元直");
    User tempUser2 = new User(2,"王海麟");

    public controller(){
        userList.add(tempUser1);
        userList.add(tempUser2);
    }

    @GetMapping("/api/users")
    public Map getAllUsers(){

        Map<String, Object> map = new HashMap<>(2);
        map.put("code",0);
        map.put("message","所有用户信息");
        map.put("data",userList);
        return map;
    }

    @GetMapping("/api/users/{id}")
    public Map getUser(@PathVariable("id") int id)
    {
        Map<String, Object> map = new HashMap<>(2);
        String message = "用户"+id+"信息";
        map.put("code","200");
        map.put("message",message);

        Map m = getAllUsers();
        List l = (List)m.get("data");

        Iterator<User> iter = l.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getId() == id) {
                map.put("code",0);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @GetMapping("/api/username/{username}")
    public Map getUserName(@PathVariable("username") String name){
        Map<String, Object> map = new HashMap<>(2);
        String message = "用户"+name+"信息";
        map.put("code","200");
        map.put("message",message);

        Map m = getAllUsers();
        List l = (List)m.get("data");

        Iterator<User> iter = l.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getName().equals(name)) {
                map.put("code",0);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @PostMapping("/api/users")
    public Map addUser(@RequestParam int id,@RequestParam String name){
        User addUser = new User(id,name);
        userList.add(addUser);

        Map<String, Object> map = new HashMap<>(2);
        map.put("code","1");
        map.put("message","添加用户");
        map.put("data",addUser);
        return map;
    }

    @PutMapping("/api/users/{id}")
    public Map updateUser(@PathVariable("id") int id,@RequestParam String name){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","更新用户");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getId()==id) {
                map.put("code",0);
                temp.setName(name);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @PutMapping("/api/usersname/{name}")
    public Map updateUserByName(@PathVariable("name") String name){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","更新用户(Name)");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getName().equals(name)) {
                map.put("code",0);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @PatchMapping("api/users/{id}")
    public Map updateDbUser(@PathVariable("id") int id){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","更新数据库用户");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getId()==id) {
                map.put("code",0);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @PatchMapping("/api/usersname/{name}")
    public Map updateDbUserByName(@PathVariable("name") String name){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","更新用户(Name)");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getName().equals(name)) {
                map.put("code",0);
                map.put("data", temp);
                break;
            }
        }
        return map;
    }

    @DeleteMapping("/api/users/{id}")
    public Map deleteUser(@PathVariable("id") int id){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","删除用户");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getId()==id) {
                map.put("code",0);
                map.put("data", temp);
                iter.remove();
                break;
            }
        }
        return map;
    }

    @DeleteMapping("/api/usersname/{name}")
    public Map deleteUserByName(@PathVariable("name") String name){
        Map<String, Object> map = new HashMap<>(2);
        map.put("code","200");
        map.put("message","删除用户");
        Iterator<User> iter = userList.iterator();
        while(iter.hasNext()){
            User temp = iter.next();
            if(temp.getName().equals(name)) {
                map.put("code",0);
                map.put("data", temp);
                iter.remove();
                break;
            }
        }
        return map;
    }
}
