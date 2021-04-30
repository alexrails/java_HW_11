package academy.belhard;

import academy.belhard.exceptions.NullFieldException;

public class Address {
    private int id;
    private String city;
    private String street;
    private int houseNumber;
    private int block;
    private int appartment;

    public Address(Integer id, String city, String street, Integer houseNumber, int block, int appartment) {
        if(id == null || city == null || street == null || houseNumber == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.block = block;
        this.appartment = appartment;
    }

    public Address(String city, String street, Integer houseNumber, int block, int appartment) {
        if(city == null || street == null || houseNumber == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.block = block;
        this.appartment = appartment;
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

    public void setId(Integer id) {
        if(id == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.id = id;
    }

    public void setCity(String city) {
        if(city == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if(street == null){
            throw new NullFieldException("Filds can't be Null!");
        }
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        if(houseNumber == null){
            throw new NullFieldException("Filds can't be Null!");
        }
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
