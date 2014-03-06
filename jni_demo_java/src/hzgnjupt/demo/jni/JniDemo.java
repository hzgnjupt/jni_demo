package hzgnjupt.demo.jni;

import java.io.UnsupportedEncodingException;

public class JniDemo {

    private static JniDemo demo = new JniDemo();

    static {
        System.loadLibrary("jni_demo_c");
    }

    /**
     * ����Ϊ�ֽ�����
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
     * ����ֵΪ�ֽ�����
     * 
     * @return
     */
    public native byte[] retByteArray();

    private static void testRetByteArray() {
        byte[] data = demo.retByteArray();
        System.out.println(new String(data));
    }

    /**
     * ����Ϊ�ַ���
     * 
     * @param data
     */
    public native void argString(String data);

    private static void testArgString() throws UnsupportedEncodingException {
        demo.argString("jni_demo: argString");
    }

    /**
     * ����ֵΪ�ַ���
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
