package business.concretes;

import business.abstracts.ICustomerService;
import core.abstracts.ICustomerControlService;
import dataAccess.abstracts.ICustomerDao;
import entities.concretes.Customer;
import java.util.List;

public class CustomerManager implements ICustomerService {
    private ICustomerDao customerDao;
    private ICustomerControlService customerControlService;

    public CustomerManager(ICustomerDao customerDao, ICustomerControlService customerControlService) {
        this.customerDao = customerDao;
        this.customerControlService = customerControlService;
    }

    @Override
    public void add(Customer customer) {
        if (!customerControlService.controlName(customer)) {
            System.out.println("Ad en az 2 karakterden oluşmalıdır !");
        }
        if (!customerControlService.controlSurname(customer)) {
            System.out.println("Soyad en az 2 karakterden oluşmalıdır !");
        }
        if (!customerControlService.controlMailFormat(customer)) {
            System.out.println("Mail adresini doğru biçimde yazınız!");
        }
        if (!customerControlService.controlPhoneNumber(customer)) {
            System.out.println("Telefon numarasını doğru formatta yazınız !");
            return;
        }
        if (!customerControlService.controlUsedMail(customer, getAll())) {
            System.out.println("Mail adresine kayıtlı başka bir müşteri bulunuyor !");
        }

        if (customerControlService.controlName(customer) && customerControlService.controlSurname(customer) &&
                customerControlService.controlMailFormat(customer) && customerControlService.controlPhoneNumber(customer) &&
                customerControlService.controlUsedMail(customer, getAll())) {
            customerDao.add(customer);
            System.out.println("Kayıt oluşturuldu");
        }


    }

    @Override
    public void delete(int customer_id) {
        if (customerControlService.controlCustomerId(customer_id, getAll())) {
            customerDao.delete(customer_id);
            System.out.println(customer_id+" numaralı ID'ye sahip müşteri silindi !");
        } else {
            System.out.println(customer_id+" numaralı ID'ye sahip müşteri bulunmuyor !");
        }

    }

    @Override
    public void update(Customer customer) {
        if (!customerControlService.controlCustomerId(customer.getCustomer_id(), getAll())) {
            System.out.println(customer.getCustomer_id() + " numaralı ID'ye sahip müşteri bulunmuyor !");
            return;
        }
        if (!customerControlService.controlName(customer)) {
            System.out.println("Ad en az iki karakterden oluşmalıdır !");
        }
        if (!customerControlService.controlSurname(customer)) {
            System.out.println("Soyad en az iki karakterden oluşmalıdır !");
        }
        if (!customerControlService.controlPhoneNumber(customer)) {
            System.out.println("Geçersiz telefon numarası !");
        }
        if (!customerControlService.controlMailFormat(customer)) {
            System.out.println("Mail formatını kontrol ediniz!");
            return;
        }
        if (!customerControlService.controlCustomerUpdateMail(customer, getAll())) {
            System.out.println("Mail adresi kullanılıyor !");
        }

        if (customerControlService.controlCustomerId(customer.getCustomer_id(),getAll())&&
                customerControlService.controlName(customer)&&customerControlService.controlSurname(customer)&&
                customerControlService.controlPhoneNumber(customer)&&customerControlService.controlMailFormat(customer)&&
        customerControlService.controlCustomerUpdateMail(customer,getAll())){
            customerDao.update(customer);
            System.out.println("Müşteri kaydı güncellendi");
        }




    }

    @Override
    public Customer get(int customer_id) {
        if (customerControlService.controlCustomerId(customer_id,getAll())){
            return customerDao.get(customer_id);
        }else {
            System.out.println(customer_id+" numaralı ID'ye sahip müşteri bulunmuyor !");
            return null;
        }

    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
