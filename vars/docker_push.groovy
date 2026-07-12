def call(Map config = [:]) {

    def imageName = config.imageName
    def imageTag = config.imageTag ?: "latest"
    def credentials = config.credentials ?: "docker"

    withCredentials([
        usernamePassword(
            credentialsId: credentials,
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
        )
    ]) {

        sh """
            echo \$PASSWORD | docker login -u \$USERNAME --password-stdin

            docker push ${imageName}:${imageTag}
            docker push ${imageName}:latest

            docker logout
        """
    }
}
