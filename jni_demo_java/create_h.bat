set JAVA_DIR=%~dp0
set C_DIR=%JAVA_DIR%..\jni_demo_c
set H_FILE=hzgnjupt_demo_jni_JniDemo.h

rem 删除C下的头文件
del /f/s/q %C_DIR%\include\%H_FILE%

rem 到bin下面生成新的头文件
cd /d %JAVA_DIR%bin
javah hzgnjupt.demo.jni.JniDemo

rem 把新的头文件移动到C下
move %JAVA_DIR%bin\%H_FILE% %C_DIR%\include\%H_FILE%