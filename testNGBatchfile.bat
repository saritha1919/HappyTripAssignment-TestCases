set projectLocation=D:\Saritha\Saritha\seleniumTraining\GIT-Selenium\HappyTripTestCases
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG testng.xml
pause