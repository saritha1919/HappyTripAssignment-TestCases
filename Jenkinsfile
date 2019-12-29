pipeline {
	agent any
	stages {
		stage('Source') { 
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saritha1919/HappyTripAssignment.git']]])
			 }
		 }
		  stage('Testing') {  
                    tools { 
                           jdk 'jdk8' 
                           maven 'Maven' 
                    } 
                   steps { 
                      powershell 'java -version' 
                      powershell 'mvn -version' 
                      powershell 'mvn -Dmaven.test.failure.ignore=true install' 
                    } 
                 } 
            }
         }
