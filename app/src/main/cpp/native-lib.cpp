#include <jni.h>
#include <string>
#include <iostream>
#include <time.h>
#include <android/log.h>
#include <stdlib.h>

#define  LOG_TAG    "ctag"

using namespace std ;



extern "C" {




            JNIEXPORT jstring JNICALL
            Java_org_lotka_ndksamples_HelloWorldActivity_helloFromJni(
                    JNIEnv *env,
                    jobject) {
                std::string hello = "Hello from C++";
                return env->NewStringUTF(hello.c_str());
            }


            JNIEXPORT jstring JNICALL
            Java_org_lotka_ndksamples_SendRetriveDataActivity_sendRetrivestring(
                    JNIEnv *env,
                    jobject,
                    jstring s) {
                return s;
            }


            JNIEXPORT jstring JNICALL
            Java_org_lotka_ndksamples_SendAndChangeStringActivity_sendretrivechangeddata(
                    JNIEnv *env,
                    jobject thiz,
                    jstring first) {
                char *c1 = " this is added part";
                char *c2 = (char *) (env->GetStringUTFChars(first, JNI_FALSE));
                char *res = strcat(c2, c1);
                return env->NewStringUTF(res);
            }


            JNIEXPORT jint  JNICALL
            Java_org_lotka_ndksamples_CalcActivity_calcfun(
                    JNIEnv *env,
                    jobject thiaz,
                    jint first,
                    jint second,
                    jint type) {
                if (type == 1) {
                    return first + second;
                } else if (type == 2) {
                    return first - second;
                } else if (type == 3) {
                    return first * second;
                } else if (type == 4) {
                    return first / second;
                }
            }


            JNIEXPORT jlong JNICALL
            Java_org_lotka_ndksamples_TimeActivity_clock(
                    JNIEnv *env,
                    jobject thiaz) {
                __android_log_write(ANDROID_LOG_INFO, LOG_TAG, "message here");
                return (long) time(NULL);
            }



            JNIEXPORT void JNICALL
            Java_org_lotka_ndksamples_ChangeVarActivity_changeValue2(
                    JNIEnv *env,
                    jclass  cls , jint javavalue) {
                jclass wrapper = env->FindClass("org/lotka/ndksamples/IntWrapper");
                jmethodID constructor = env->GetMethodID(wrapper, "<init>", "(I)V");
                jobject wrapperObject = env->NewObject(wrapper, constructor ,javavalue );
                jmethodID getInt = env->GetMethodID(wrapper, "getInt", "()I");
                jint ret = env->CallIntMethod(wrapperObject, getInt);
                printf("Wrapper value: %d\n", ret);

                jmethodID inc3 = env->GetStaticMethodID(cls, "inc3",
                                                        "(Lorg/lotka/ndksamples/IntWrapper;)V");
                env->CallStaticVoidMethod(cls, inc3, wrapperObject);

                ret = env->CallIntMethod(wrapperObject, getInt);
                printf("Wrapper value after increment: %d\n", ret);

            }



                JNIEXPORT void JNICALL
                Java_org_lotka_ndksamples_MyChangeActivity_myfunction4int(
                        JNIEnv *env ,
                        jclass cls,
                        jobject obj){
                    jclass myjclass = env->GetObjectClass(obj);
                    jfieldID myjfield43 =  env->GetFieldID(myjclass, "a", "I") ;
                    env->SetIntField(obj, myjfield43, 50);

                }



                JNIEXPORT void JNICALL
                Java_org_lotka_ndksamples_MyChangeActivity_myfunction4string(
                        JNIEnv *env ,
                        jclass cls,
                        jobject obj){
                    jclass myjclass = env->GetObjectClass(obj);
                    jfieldID myjfield44 =  env->GetFieldID(myjclass, "b", "Ljava/lang/String;") ;
                    jstring ss = env->NewStringUTF("changed");
                    env->SetObjectField(obj , myjfield44 , ss);
                }



                JNIEXPORT void JNICALL
                Java_org_lotka_ndksamples_MyChangeActivity_myfunction4boolean(
                        JNIEnv *env ,
                        jclass cls,
                        jobject obj){
                    jclass myjclass = env->GetObjectClass(obj);
                    jfieldID myjfield45 =  env->GetFieldID(myjclass, "c", "Z") ;
                    jstring ss = env->NewStringUTF("changed");
                    env->SetBooleanField(obj , myjfield45 , 1);

                }




                JNIEXPORT jarray JNICALL
                Java_org_lotka_ndksamples_jnilistActivity_flist(JNIEnv *env, jobject thiz , jarray javaarray) {
                    return javaarray;
                }


                JNIEXPORT jint JNICALL
                Java_org_lotka_ndksamples_A1121Activity_getversion1121(JNIEnv *env, jobject thiz) {
                    return env->GetVersion();
                }


                JNIEXPORT jint JNICALL
                Java_org_lotka_ndksamples_A1121Activity_fromreflected(JNIEnv *env, jobject thiz) {
                    jmethodID jm = env->FromReflectedMethod(thiz);
                    
                }






}

