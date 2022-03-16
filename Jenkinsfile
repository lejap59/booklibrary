pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }

    stages {
 
        stage('Compile') {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage('Unit test') {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [reportDir: 'build/reports/jacoco/test/html',
                                      reportFiles: 'index.html',
                                      reportName: 'Jacoco Report'
                             ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("Static code analysis") {
            steps {
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: "Checkstyle Report"
                ])
            }
        }    

        stage("build") {
            steps {
                sh "./gradlew build"
            }
        }

        /*stage("Docker build") {
            steps {
                sh "docker build -t lejap59/calculator ."
            }
        }*/
        /*stage("Docker login") {
     steps {
          withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub-credentials',
                   usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
               sh "docker login --username $USERNAME --password $PASSWORD"
          }
     }
}*/
    stage ("acceptance tests") {
        steps {
            sleep 3
            sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
            sleep 10
            sh "cucumber"
       }

    }

    }
}
