package com.codegym.penzuproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @Lob
    private String avatar;

    @Lob
    private String blobString;

    private LocalDateTime date;

    @ManyToOne
    private Tag tag;

    @ManyToOne
    private User user;

    public Tag getTag() {
        return tag;
    }

    public User getUser() {
        return user;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String now = date.format(format);
        return now;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBlobString() {
        return blobString;
    }

    public void setBlobString(String blobString) {
        this.blobString = blobString;
    }
}
