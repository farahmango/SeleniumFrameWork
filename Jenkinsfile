pipeline {

    agent any
    triggers{
        pollSCM '* * * * *'
    }
    tools {
        maven 'Apache_Maven'
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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
                 
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying the application...'
                sh 'mvn deploy'
            }
        }
    }
}
