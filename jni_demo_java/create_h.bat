set JAVA_DIR=%~dp0
set C_DIR=%JAVA_DIR%..\jni_demo_c
set H_FILE=hzgnjupt_demo_jni_JniDemo.h

rem ɾ��C�µ�ͷ�ļ�
del /f/s/q %C_DIR%\include\%H_FILE%

rem ��bin���������µ�ͷ�ļ�
cd /d %JAVA_DIR%bin
javah hzgnjupt.demo.jni.JniDemo

rem ���µ�ͷ�ļ��ƶ���C��
move %JAVA_DIR%bin\%H_FILE% %C_DIR%\include\%H_FILE%