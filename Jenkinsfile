pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            /* when {
                anyOf {
                    branch 'master'
                    branch 'dev'
                }
            } */
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
                jacoco(
                    classPattern: 'app/build/classes',
                    inclusionPattern: '**/*.class',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'app/build/jacoco/**/*.exec'
                )
            }
        }
        stage('sonarqube-analysis') {
            environment {
                SONAR_TOKEN = credentials('{8ff243ecb0324171cb08a7caa8a52a6c7f7eb3bb}')
            }
            steps {
                sh '''./gradlew sonarqube \
                    -Dsonar.projectKey=d0745378-swimming-pool \
                    -Dsonar.host.url=http://140.134.26.54:10990 \
                    -Dsonar.login=$SONAR_TOKEN
                '''
            }
        }
//         8ff243ecb0324171cb08a7caa8a52a6c7f7eb3bb
    }
}