package com.arseeniy.randomize.common;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_history")
public class RequestHistoryEntity {

    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeq")
    private Integer id;

    @Column(name = "min")
    private Integer min;

    @Column(name = "max")
    private Integer max;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;
    @Column(name = "result")
    private Integer result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
