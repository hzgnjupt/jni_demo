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

    public static void main(String[] args) throws Exception {

        testArgByteArray();
        testRetByteArray();
        testArgString();
        testRetString();
    }

}
