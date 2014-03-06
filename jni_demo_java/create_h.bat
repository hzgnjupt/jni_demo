set JAVA_DIR=%~dp0
set C_DIR=%JAVA_DIR%..\jni_demo_c
set H_FILE=hzgnjupt_demo_jni_JniDemo.h

del /f/s/q %C_DIR%\include\%H_FILE%

cd /d %JAVA_DIR%bin
javah hzgnjupt.demo.jni.JniDemo

move %JAVA_DIR%bin\%H_FILE% %C_DIR%\include\%H_FILE%