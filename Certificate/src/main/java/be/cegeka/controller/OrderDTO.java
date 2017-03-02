package be.cegeka.controller;

public class OrderDTO {

    private String workOrderNumber;
    private String purchaseOrderNumber;
    private String specification;
    private int total;
    private int customerId;

    public OrderDTO(String workOrderNumber, String purchaseOrderNumber, String specification, int total, int customerId) {
        this.workOrderNumber = workOrderNumber;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.specification = specification;
        this.total = total;
        this.customerId = customerId;
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

    public int getKlantId() {
        return customerId;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
