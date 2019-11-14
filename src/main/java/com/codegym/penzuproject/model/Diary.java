package com.codegym.penzuproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private String title;
    private String description;
    private String file;

    @Lob
    private String content;

    @ManyToOne
    private Tag tag;

    @ManyToOne
    private User user;

    public Diary(LocalDateTime date, String title, String description, String file, String content, Tag tag, User user) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
        this.tag = tag;
        this.user = user;
    }

    public Diary(LocalDateTime date, String title, String description, String file, String content, Tag tag) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
        this.tag = tag;
    }

    public Diary() {
    }

    public Diary(LocalDateTime date, String title, String description, String file, String content) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
