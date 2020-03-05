pipeline {
	agent any
	stages {
		stage('Source') { 
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/saritha1919/HappyTripAssignment-TestCases.git']]])
			 }
		 }
		  stage('Testing') {  
                    tools { 
                           jdk 'jdk8' 
                           maven 'Maven' 
                    } 
                   steps { 
                     bat label: '', script: 'mvn test -Denvironment=${env}'
                    } 
                 } 
            }
         }
