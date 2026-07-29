def call(Map config = [:]) {

    def imageName = config.imageName
    def imageTag = config.imageTag ?: "latest"
    def credentialsId = config.credentials ?: "docker"

    if (!imageName) {
        error "imageName is required for docker_push"
    }

    withCredentials([
        usernamePassword(
            credentialsId: credentialsId,
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
        )
    ]) {

        sh """
            set +x

            echo "\$PASSWORD" | docker login \
                -u "\$USERNAME" \
                --password-stdin

            docker push ${imageName}:${imageTag}
            docker push ${imageName}:latest

            docker logout
        """
    }
}
