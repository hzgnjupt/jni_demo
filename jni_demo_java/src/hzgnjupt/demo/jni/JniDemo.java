package hzgnjupt.demo.jni;

import java.io.UnsupportedEncodingException;

public class JniDemo {

    private static JniDemo demo = new JniDemo();

    static {
        System.loadLibrary("jni_demo_c");
    }

    /**
     * 参数为字节数组
     * 
     * @param data
     * @param len
     */
    public native void argByteArray(byte[] data, int len);

    private static void testArgByteArray() {
        byte[] data = new String("jni_demo: argByteArray").getBytes();
        demo.argByteArray(data, data.length);
        System.out.println(new String(data));
    }

    /**
     * 返回值为字节数组
     * 
     * @return
     */
    public native byte[] retByteArray();

    private static void testRetByteArray() {
        byte[] data = demo.retByteArray();
        System.out.println(new String(data));
    }

    /**
     * 参数为字符串
     * 
     * @param data
     */
    public native void argString(String data);

    private static void testArgString() throws UnsupportedEncodingException {
        demo.argString("jni_demo: argString");
    }

    /**
     * 返回值为字符串
     * 
     * @return
     */
    public native String retString();

    private static void testRetString() {
        System.out.println(demo.retString());
    }

    /**
     * 参数和返回值为int类型
     * 
     * @param a
     * @param b
     */
    public native int argretInt(int a, int b);

    private static void testArgRetInt() {
        System.out.println("1 + 2 = " + demo.argretInt(1, 2));
    }

    /**
     * 参数和返回值为double类型
     * 
     * @param a
     * @param b
     */
    public native double argretDouble(double a, double b);

    private static void testArgRetDouble() {
        System.out.println("100 / 3 = " + demo.argretDouble(100, 3));
    }

    /**
     * 参数和返回值为对象
     * 
     * @param a
     * @param b
     */
    public native Foo argretObj(Foo obj);

    private static void testArgRetObj() {

        Foo foo1 = new Foo(1, "a");
        System.out.println("before argretObj: foo1 = " + foo1);
        Foo foo2 = demo.argretObj(foo1);
        System.out.println("after argretObj: foo1 = " + foo1);
        System.out.println("after argretObj: foo2 = " + foo2);

    }

    public static void main(String[] args) throws Exception {

        testArgByteArray();
        testRetByteArray();
        testArgString();
        testRetString();
        testArgRetInt();
        testArgRetDouble();
        testArgRetObj();
    }

}
