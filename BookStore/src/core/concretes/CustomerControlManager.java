package core.concretes;

import core.abstracts.ICustomerControlService;
import entities.concretes.Customer;

import java.util.List;
import java.util.regex.Pattern;

public class CustomerControlManager implements ICustomerControlService {

    // Müşteri adının uzunluğu kontrol ediliyor
    @Override
    public boolean controlName(Customer customer) {
        if (customer.getCustomer_name().length() < 2) {
            return false;
        }
        return true;
    }

    // Müşteri soyadının uzunluğu kontrol ediliyor
    @Override
    public boolean controlSurname(Customer customer) {
        if (customer.getCustomer_surname().length() < 2) {
            return false;
        }
        return true;
    }

    // Mail formatı kontrol ediliyor
    @Override
    public boolean controlMailFormat(Customer customer) {
        String mail = customer.getCustomer_email();
        boolean gmailCom = Pattern.matches(".*@gmail.com", mail);
        if (gmailCom) {
            return true;
        } else {
            return false;
        }

    }

    // Girilen mail adresine sahip başka bir müşteri var mı diye kontrol ediliyor
    @Override
    public boolean controlUsedMail(Customer customer, List<Customer> customers) {
        for (Customer controlCustomer : customers) {
            if (controlCustomer.getCustomer_email().equals(customer.getCustomer_email())) {
                return false;
            }
        }
        return true;
    }

    // Telefon numarasının formatı kontrol ediliyor
    @Override
    public boolean controlPhoneNumber(Customer customer) {
        String phoneNumber = customer.getCustomer_phoneNumber();
        boolean none = Pattern.matches("0.*", phoneNumber);
        if (phoneNumber.length() == 10 && !none) {
            return true;
        } else {
            return false;
        }
    }

    // Girilen ID'ye sahip müşteri var mı diye kontrol ediliyor
    @Override
    public boolean controlCustomerId(int customer_id, List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getCustomer_id() == customer_id) {
                return true;
            }
        }
        return false;
    }

    // Müşteri bilgileri güncellenirken mail adresine sahip başka bir müşteri var mı diye kontrol ediyor
    @Override
    public boolean controlCustomerUpdateMail(Customer customer, List<Customer> customers) {
        boolean controlUsedMail = controlUsedMail(customer, customers);
        boolean controlCustomerUpdateMail = false;

        // Müşteri aynı mail adresini kullanmaya devam edecekse true sonucunu alıyoruz
        for (Customer controlCustomer : customers) {
            if (controlCustomer.getCustomer_id() == customer.getCustomer_id() &&
                    controlCustomer.getCustomer_email().equals(customer.getCustomer_email())) {
                controlCustomerUpdateMail = true;
            }
        }

        if (controlCustomerUpdateMail) {
            // Müşteri aynı mail adresini kullanmöaya devam edeceği durum
            return true;
        } else if (controlCustomerUpdateMail == false && controlUsedMail == false) {
            // Müşteri mail adresi değişeceğinde, değişen mail adresine sahip başka bir müşteri olma durumu
            return false;
        } else if (controlCustomerUpdateMail == false && controlUsedMail == true) {
            // Müşteri mail adresi değişeceğinde, değişen mail adresine sahip başka bir müşteri olmadığı durum
            return true;
        }


        return false;
    }


}
