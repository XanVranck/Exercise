package be.cegeka.domain.order;

import be.cegeka.domain.certificaat.Certificaat;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xanv on 28/02/2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderID;

    @Column(name = "WORK_ORDER_NUMBER", unique = true)
    private String workOrderNumber;

    @Column(name = "PUCHASE_ORDER_NUMBER")
    private String purchaseOrderNumber;

    @Column(name = "SPECIFICATIE")
    private String specification;

    @Column
    private int total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Certificaat> certificaten;

    public Order() {
    }

    public Order(String workOrderNumber, String purchaseOrderNumber, String specification, int total) {
        this.workOrderNumber = workOrderNumber;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.specification = specification;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public String getSpecification() {
        return specification;
    }

    public int getTotal() {
        return total;
    }
}
