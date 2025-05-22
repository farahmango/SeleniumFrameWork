pipeline {
    agent any
    triggers{
        pollSCM '* * * * *'
    }
    stages {
        stage('biuld') {
            steps {
                echo 'building the code'
            }
        }
    stage('test') {
        steps {
            echo 'testing the code'
        }
    }
    }
}
