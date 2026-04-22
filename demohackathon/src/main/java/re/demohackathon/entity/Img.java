package re.demohackathon.entity;

public class Img {
    private int a;
    private int b;
    private String url;

    public Img() {
    }

    public Img(int a, int b, String url) {
        this.a = a;
        this.b = b;
        this.url = url;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
