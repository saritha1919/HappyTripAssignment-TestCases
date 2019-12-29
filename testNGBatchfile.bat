set projectLocation=C:\Program Files (x86)\Jenkins\workspace\HappyTrip-testcases
cd %projectLocation%
set classpath=%projectLocation%\target\test-classes;%projectLocation%\lib\*
java org.testng.TestNG testsuite.xml
pause