pipeline {
    agent any

    stages {
        stage('Fetch') {
            steps {
                // Get some code from a GitHub repository
                git('https://github.com/Vds123/devops-backend')
            }
        }
        
        stage('test') {
            steps {
                sh "mvn clean test"
            }
        }
    }
}