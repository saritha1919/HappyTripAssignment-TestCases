set projectLocation=C:\Program Files (x86)\Jenkins\workspace\HappyTrip-testcases
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testsuite.xml
pause
