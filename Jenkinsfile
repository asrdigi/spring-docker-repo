pipeline {
    agent any

    environment
    {
    	password=credentials('password') 
    }
    
    stages {
        stage('Compile and Clean') { 
            steps {

                sh script: '''mvn -f pom.xml compile'''
            }
        }
       
	stage('Junit5 Test') { 
            steps {

                sh script: '''mvn -f pom.xml test'''
            }
        }

	stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
		}
	}

	stage('SonarQube'){
		steps{
				sh label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:9000 \
				-Dsonar.login='squ_8545723f76f699081eb365fd34da843303f5b1cd''
			}
   	}
        
        stage('Maven Build') { 
            steps {
                sh script: '''mvn  clean install'''
            }
        }


        stage('Build Docker image'){
            steps {
            	 sh script: '''docker build -t spring-rest-pipeline:latest .'''
		}
        }

        stage('Docker Login'){
           
	    
            steps {
                    withCredentials([usernamePassword(credentialsId: 'docker_id', passwordVariable: 'password', usernameVariable: 'docker_id')]) {
    			sh script: '''docker login -u $username -p $password'''
		       }
		}
		   
            }                
        

        stage('Docker Push'){
            steps {
                sh script '''docker push 9246115521:spring-rest-pipeline:latest'''
            }
        } 
}
}
