pipeline {
  agent any
  tools{
    maven 'Maven3.8.7'
    jdk 'JDK17'
  }
  stages {

	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
// 			bat label: 'Compilation running', script: '''mvn compile'''
            sh 'mvn clean compile'
	       	}
	}

	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
// 			bat label: 'Test running', script: '''mvn test'''
            sh 'mvn test'
       		}
   	}

	stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
		}
	}


    stage('SonarQube'){
		steps{
				sh 'mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.login=1253462271033e5e26325c3fba29a9031551325'
			}
   		}

	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
// 			bat label: 'Project packaging', script: '''mvn package'''
            sh 'mvn build'
		}

	}


  }

  

}
