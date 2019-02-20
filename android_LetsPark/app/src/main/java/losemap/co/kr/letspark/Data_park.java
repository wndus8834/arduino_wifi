package losemap.co.kr.letspark;

public class Data_park {
    String parknum,onoff,dt;
    // 서버에서 받은 데이터를 안드로이드에서 받기 위한 클래스 객체

    public Data_park(String parknum, String onoff, String dt) {
        this.parknum = parknum;
        this.onoff = onoff;
        this.dt = dt;
    }

    public String getParknum() {
        return parknum;
    }

    public void setParknum(String parknum) {
        this.parknum = parknum;
    }

    public String getOnoff() {
        return onoff;
    }

    public void setOnoff(String onoff) {
        this.onoff = onoff;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}
