package com.codegym.penzuproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @Lob
    private String title;

    @Lob
    private String description;

    @Lob
    private String file;

    private String typeFile;


    private Boolean isUpdate;

    @Lob
    private String content;

    @ManyToOne
    private Tag tag;

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class , mappedBy = "diary" , cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Diary(String date, String title, String description, String file, String typeFile, Boolean isUpdate, String content, Tag tag, User user, List<Comment> comments) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.typeFile = typeFile;
        this.isUpdate = isUpdate;
        this.content = content;
        this.tag = tag;
        this.user = user;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Diary(String date, String title, String description, String file, String typeFile, Boolean isUpdate, String content, Tag tag, User user) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.typeFile = typeFile;
        this.isUpdate = isUpdate;
        this.content = content;
        this.tag = tag;
        this.user = user;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public String getUpdate() {
        return isUpdate.toString();
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }

    public Diary(String date, String title, String description, String file, Boolean isUpdate, String content, Tag tag, User user) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.isUpdate = isUpdate;
        this.content = content;
        this.tag = tag;
        this.user = user;
    }

    public Diary(String date, String title, String description, String file, String content, Tag tag, User user) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
        this.tag = tag;
        this.user = user;
    }

    public Diary(String date, String title, String description, String file, String content, Tag tag) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
        this.tag = tag;
    }

    public Diary() {
    }

    public Diary(String date, String title, String description, String file, String content) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
