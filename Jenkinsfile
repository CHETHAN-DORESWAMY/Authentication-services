pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        jdk "jdk-23"
    }

    stages {
        stage('Git') {
            steps {
                // Get some code from a GitHub repository
                git url : 'https://github.com/CHETHAN-DORESWAMY/Authentication-services.git', branch: 'master'
                // Run Maven on a Unix agent.

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                bat "mvn clean install -DskipTests"

                // Run Maven on a Unix agent.

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }
        stage('Tests') {
            steps {
                // Get some code from a GitHub repository
                bat "mvn test"

                // Run Maven on a Unix agent.

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }
        stage('Deploy') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/sep-2024-trivandrum/authentication-service'
                bat "docker build -t authentication-image ."
//                 bat "docker network create -d bridge chethan-network"
			    bat "docker run --network chethan-network -p 8090:8090 -d --name authentication-sr authentication-image"

            }


        }
    }
}