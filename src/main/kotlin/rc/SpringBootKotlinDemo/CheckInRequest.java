package rc.SpringBootKotlinDemo;

public class CheckInRequest {
    private String hotelName;
    private int nbGuest;

    public CheckInRequest() {
    }

    public CheckInRequest(String hotelName, int nbGuest) {
        this.hotelName = hotelName;
        this.nbGuest = nbGuest;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNbGuest() {
        return nbGuest;
    }

    public void setNbGuest(int nbGuest) {
        this.nbGuest = nbGuest;
    }
}
