pipeline {
    agent any

    environment {
        APICTL = 'C:/apictl'  // Ruta donde está apictl en tu servidor Jenkins
        WSO2_API_MANAGER_URL = 'https://localhost:9443'  // URL del portal de WSO2
        API_NAME = 'TestAPI'  // Nombre de la API
        API_VERSION = '1'  // Versión de la API
        API_PATH = 'http://localhost:8080/v3/api-docs'  // Ruta en tu repositorio donde está el archivo Swagger
    }

    stages {
        stage('Checkout Code from GitHub') {
            steps {
                // Clonamos el repositorio de GitHub
                git 'https://github.com/juan-chanaga-artemisa/testAPI.git'
            }
        }

        stage('Login to WSO2 API Manager') {
            steps {
                // Iniciar sesión en WSO2 usando apictl
                sh """
                ${APICTL} login -u admin -p admin -k --server ${WSO2_API_MANAGER_URL}
                """
            }
        }

        stage('Update WSO2 Resources') {
            steps {
                // Actualizamos los recursos en WSO2
                sh """
                ${APICTL} apis import --api-file ${API_PATH}/${API_NAME}-${API_VERSION}.swagger
                """
            }
        }

        stage('Deploy API') {
            steps {
                // Desplegamos la API
                sh """
                ${APICTL} apis deploy --api ${API_NAME} --version ${API_VERSION} --environment 'Production'
                """
            }
        }
    }

    post {
        always {
            echo 'Pipeline completado.'
        }
    }
}
