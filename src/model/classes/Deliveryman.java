package model.classes;

import model.enums.DeliverymanStatus;
import model.enums.Jobdesk;

public class Deliveryman extends Employee {
    private DeliverymanStatus status;

    public Deliveryman(Integer id, String name, String email, String password, String cellphone, Jobdesk jobdesk, DeliverymanStatus status) {
        super(id, name, email, password, cellphone, jobdesk);
        this.status = status;
    }

    public DeliverymanStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverymanStatus status) {
        this.status = status;
    }
}
