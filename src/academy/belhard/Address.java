package academy.belhard;

public class Address {

    int id;
    String city;
    String street;
    int house_number;
    int corps_number;
    int apartment_number;

    public Address(int id, String city, String street, int house_number, int corps_number, int apartment_number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.corps_number = corps_number;
        this.apartment_number = apartment_number;
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

    public int getHouse_number() {
        return house_number;
    }

    public int getCorps_number() {
        return corps_number;
    }

    public int getApartment_number() {
        return apartment_number;
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

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public void setCorps_number(int corps_number) {
        this.corps_number = corps_number;
    }

    public void setApartment_number(int apartment_number) {
        this.apartment_number = apartment_number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house_number=" + house_number +
                ", corps_number=" + corps_number +
                ", apartment_number=" + apartment_number +
                '}';
    }
}
