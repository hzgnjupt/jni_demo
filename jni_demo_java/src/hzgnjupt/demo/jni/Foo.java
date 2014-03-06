package hzgnjupt.demo.jni;

public class Foo {

    private int number;
    private String str;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Foo(int number, String str) {
        this.number = number;
        this.str = str;
    }

    @Override
    public String toString() {
        return "Foo [number=" + number + ", str=" + str + "]";
    }

}
