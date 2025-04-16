package com.pdetoni.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pdetoni.course.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;

    private Integer status;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status,User client) {
        super();
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if(status!=null) this.status = status.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return getId().equals(order.getId()) && getMoment().equals(order.getMoment()) && getClient().equals(order.getClient());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMoment().hashCode();
        result = 31 * result + getClient().hashCode();
        return result;
    }
}
