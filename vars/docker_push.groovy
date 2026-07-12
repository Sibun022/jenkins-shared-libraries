def call(Map config = [:]) {

    def imageName = config.imageName
    def imageTag = config.imageTag ?: "latest"
    def credentials = config.credentials ?: "docker-hub-credentials"

    withCredentials([
        usernamePassword(
            credentialsId: credentials,
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {

        sh """
            set -e

            echo "Logging into Docker Hub..."
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin

            echo "Pushing ${imageName}:${imageTag}"
            docker push ${imageName}:${imageTag}

            echo "Pushing ${imageName}:latest"
            docker push ${imageName}:latest

            docker logout
        """
    }
}
