pipeline {
    agent any
    triggers{
        pollSCM '* * * * *'
    }
    stages {
        stage('biuld') {
            steps {
                mvn compile
            }
        }
    stage('test') {
        steps {
            mvn clean test
        }
    }
    }
}
