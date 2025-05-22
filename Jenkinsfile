pipeline {
    agent any
    // triggers{
    //     pollSCM '* * * * *'
    // }
   stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script{
                echo 'Building the project...'
                echo 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                 script{
                echo 'Running tests...'
                echo 'mvn test'
                 }
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                 script{
                echo 'Deploying the application...'
                bat 'mvn deploy'
                 }
            }
        }
    }
}
