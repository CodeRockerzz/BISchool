pipeline {
    agent any 
    stages {
        stage('SCM Checkout') { 
            steps {
              git credentialsId: 'git-password', url: 'https://github.com/CodeRockerzz/DockerApp.git'
            }
        }
        stage('Mvn Package') { 
            steps {
                def mvnHome= tool name:'Maven',type:'maven'
				def mvnCMD = "${mvnHome}/bin/mvn"
				sh"${mvnCMD} clean package" 
            }
        }
       
    }
}
