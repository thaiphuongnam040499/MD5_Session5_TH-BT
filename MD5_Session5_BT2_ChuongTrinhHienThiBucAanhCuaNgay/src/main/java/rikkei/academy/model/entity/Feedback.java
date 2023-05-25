package rikkei.academy.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;
    private String author;
    private String message;
    private Date date=new java.sql.Date(new java.util.Date().getTime());

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Feedback(Long id, int point, String author, String message, Date date) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.message = message;
        this.date = new java.sql.Date(new java.util.Date().getTime());
    }
}
