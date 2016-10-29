package api;

public class GumballJackson {

    private String banner;

    private int count;

    private String state;

    public String getBanner() {
        return banner;
    }

    public int getCount() {
        return count;
    }

    public String getState() {
        return state;
    }

    public void setBanner(String content) {
        this.banner = content;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(String state) {
        this.state = state;
    }

}
