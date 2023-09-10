pipeline {
  agent any
  tools{
    maven 'Maven3.8.7'
    jdk 'JDK17'
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('mydockerid')
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
				-Dsonar.login=squ_add765f23ea0291addbbc6c688176bc39ab94f53'
			}
   		}

	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
// 			bat label: 'Project packaging', script: '''mvn package'''
            		sh 'mvn install'
		}

	}


    stage('Docker Build Image') {
      steps {
        sh 'docker build -t 9246115521/spring-jenkins-docker .'
      }
    }
	  
    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }
	  
    stage('Push') {
      steps {
        sh 'docker push 9246115521/spring-jenkins-docker'
      }
    }
	  


  }

  post {
    always {
      sh 'docker logout'
    }
  }

}
