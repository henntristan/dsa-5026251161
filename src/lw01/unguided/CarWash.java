package lw01.unguided;

public class CarWash extends WashService {

    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int dayCharge;
        if (days <= 3) {
            dayCharge = days * 35000;
        } else {
            dayCharge = (3 * 35000) + ((days - 3) * 25000);
        }
        return dayCharge + 15000;
    }

    @Override
    public String label() {
        return "Car";
    }
}
