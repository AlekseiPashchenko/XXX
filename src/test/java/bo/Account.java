package bo;

/**
 * Created by apashchenko on 18.06.2017.
 */
public class Account {
    private int phone;
    private int passcode;
    private String iban;
    private String swift;

    public Account(int phone, int passcode, String iban, String swift){
        this.phone = phone;
        this.passcode = passcode;
        this.iban = iban;
        this.swift = swift;
    }

    public int getPhone() {
        return phone;
    }

    public int getPasscode() {
        return passcode;
    }

    public String getSwift() {
        return swift;
    }

    public String getIban() {
        return iban;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
