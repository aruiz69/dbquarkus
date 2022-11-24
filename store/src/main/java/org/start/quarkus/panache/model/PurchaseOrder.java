package org.start.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.start.quarkus.panache.entitylegacy.Customer;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_purcharse_orders")
public class PurchaseOrder extends PanacheEntity {
    @Column(name = "created_date")
    public Instant createdDate = Instant.now();
    @JoinColumn(name = "customner_purchase_order")
    @ManyToOne
    public Customer customer;
    @OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<OrderLine> orderLines = new ArrayList<>();

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }
}
