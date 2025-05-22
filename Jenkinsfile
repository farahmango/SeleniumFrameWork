pipeline {
    agent any
    // triggers{
    //     pollSCM '* * * * *'
    // }
    tools { 
      maven 'Apache_Maven' 
      jdk 'JDK' 
     }
   stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
                 
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying the application...'
                bat 'mvn deploy'
            }
        }
    }
}
