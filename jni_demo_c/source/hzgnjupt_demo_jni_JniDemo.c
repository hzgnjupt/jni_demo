#include "windows.h"
#include "hzgnjupt_demo_jni_JniDemo.h"

JNIEXPORT void JNICALL Java_hzgnjupt_demo_jni_JniDemo_argByteArray
  (JNIEnv *env, jobject obj, jbyteArray data, jint len)
{	
	int i;
	jbyte *b;
	b = (*env)->GetByteArrayElements(env, data, JNI_FALSE);
	for(i = 0; i < len; i++)
	{
		if(*(b + i) >= 'a' && *(b + i) <= 'z')
		{
			*(b + i) = *(b + i) + ('A' - 'a');
		}
	}
	(*env)->SetByteArrayRegion(env, data, 0, len, b);
}

JNIEXPORT jbyteArray JNICALL Java_hzgnjupt_demo_jni_JniDemo_retByteArray
  (JNIEnv *env, jobject obj)
{
	char *str = "jni_demo: retByteArray";
	jbyteArray data = (*env)->NewByteArray(env, strlen(str));
	(*env)->SetByteArrayRegion(env, data, 0, strlen(str), str);
	return data;
}

JNIEXPORT void JNICALL Java_hzgnjupt_demo_jni_JniDemo_argString
  (JNIEnv *env, jobject obj, jstring data)
{
	const char *str;
	str = (*env)->GetStringUTFChars(env, data, JNI_FALSE);
	printf("%s\n", str);
	(*env)->ReleaseStringUTFChars(env, data, str);
}

JNIEXPORT jstring JNICALL Java_hzgnjupt_demo_jni_JniDemo_retString
  (JNIEnv *env, jobject obj)
{
	return (*env)->NewStringUTF(env, "jni_demo: retString");
}

JNIEXPORT jint JNICALL Java_hzgnjupt_demo_jni_JniDemo_argretInt
  (JNIEnv *env, jobject obj, jint a, jint b)
{
	return a + b;
}

JNIEXPORT jdouble JNICALL Java_hzgnjupt_demo_jni_JniDemo_argretDouble
  (JNIEnv *env, jobject obj, jdouble a, jdouble b)
{
	return a / b;
}

JNIEXPORT jobject JNICALL Java_hzgnjupt_demo_jni_JniDemo_argretObj
  (JNIEnv *env, jobject obj, jobject foo)
{
	jclass class_Foo = (*env)->GetObjectClass(env,foo);
	jfieldID fdNumber = (*env)->GetFieldID(env,class_Foo,"number","I");
	jfieldID fdStr = (*env)->GetFieldID(env,class_Foo,"str","Ljava/lang/String;");
	jmethodID mdcstr = (*env)->GetMethodID(env, class_Foo, "<init>", "(ILjava/lang/String;)V");
	jobject objFoo2;

	(*env)->SetIntField(env, foo, fdNumber, 2);
	(*env)->SetObjectField(env, foo, fdStr, (*env)->NewStringUTF(env, "b"));

	objFoo2 = (*env)->NewObject(env, class_Foo, mdcstr, 3, (*env)->NewStringUTF(env, "c"));

	return objFoo2;
}
