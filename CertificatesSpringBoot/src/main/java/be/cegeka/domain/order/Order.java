package be.cegeka.domain.order;

import javax.persistence.*;

/**
 * Created by xanv on 28/02/2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int klantenID;

    @Column(name = "WORK_ORDER_NUMBER")
    private String workOrderNumber;

    @Column(name = "PUCHASE_ORDER_NUMBER")
    private String purchaseOrderNumber;

    @Column(name = "SPECIFICATIE")
    private String specification;

    @Column
    private int total;

    public Order() {
    }

    public Order(String workOrderNumber, String purchaseOrderNumber, String specification, int total) {
        this.workOrderNumber = workOrderNumber;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.specification = specification;
        this.total = total;
    }

    public int getKlantenID() {
        return klantenID;
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
