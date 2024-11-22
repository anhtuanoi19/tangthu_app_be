package com.example.tangthu_app_be.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;

    public User() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
