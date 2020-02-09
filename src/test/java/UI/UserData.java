package UI;

public class UserData {
    private String HouseNumber;
    private String StreetName;
    private String City;
    private String PostCode;
    private String Country;
    private int CardNumber;
    private String Expires;
    private int CCV;

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpires() {
        return Expires;
    }

    public void setExpires(String expires) {
        Expires = expires;
    }

    public int getCCV() {
        return CCV;
    }

    public void setCCV(int CCV) {
        this.CCV = CCV;
    }
}
