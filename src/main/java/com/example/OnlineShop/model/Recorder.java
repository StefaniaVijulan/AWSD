package com.example.OnlineShop.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "Recorder")
public class Recorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecorder;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRecorded;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExpected;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Recorder(Integer idRecorder, Date dateRecorded, Date dateExpected, Order order) {
        this.idRecorder = idRecorder;
        this.dateRecorded = dateRecorded;
        this.dateExpected = dateExpected;
        this.order = order;
    }

    public Recorder() {

    }

    public Integer getIdRecorder() {
        return idRecorder;
    }

    public void setIdRecorder(Integer idRecorder) {
        this.idRecorder = idRecorder;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Date getDateExpected() {
        return dateExpected;
    }

    public void setDateExpected(Date dateExpected) {
        this.dateExpected = dateExpected;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
