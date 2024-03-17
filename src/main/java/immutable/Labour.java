package immutable;

public final class Labour {
    private final int id;
    private final String name;
    private Address address;

    public Labour(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
class Address{
    private String city;
    private String pincode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Address(String city, String pincode) {
        this.city = city;
        this.pincode = pincode;
    }
}