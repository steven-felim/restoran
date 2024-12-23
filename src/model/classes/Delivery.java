package model.classes;

import model.enums.DeliveryStatus;

public class Delivery {
    private int delivery_id;
    private DeliveryStatus deliveryStatus;
    private int transaction_id;
    private int deliveryman_id;
    private String address;

    public Delivery(int delivery_id, DeliveryStatus deliveryStatus, String address, int transaction_id, int deliveryman_id) {
        this.delivery_id = delivery_id;
        this.deliveryStatus = deliveryStatus;
        this.address = address;
        this.transaction_id = transaction_id;
        this.deliveryman_id = deliveryman_id;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getDeliveryman_id() {
        return deliveryman_id;
    }

    public void setDeliveryman_id(int deliveryman_id) {
        this.deliveryman_id = deliveryman_id;
    }
}
