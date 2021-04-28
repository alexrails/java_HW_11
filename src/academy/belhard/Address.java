package academy.belhard;

public class Address {
    private int id;
    private String city;
    private String street;
    private int houseNumber;
    private int block;
    private int appartment;

    public Address(int id, String city, String street, int houseNumber, int block, int appartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.block = block;
        this.appartment = appartment;
    }

    public Address(int id, String city, String street, int houseNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getBlock() {
        return block;
    }

    public int getAppartment() {
        return appartment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setAppartment(int appartment) {
        this.appartment = appartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", block=" + block +
                ", appartment=" + appartment +
                '}';
    }
}
