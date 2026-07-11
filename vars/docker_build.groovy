def call(Map config = [:]) {

    def imageName = config.imageName
    def imageTag = config.imageTag ?: "latest"
    def dockerfile = config.dockerfile ?: "Dockerfile"
    def context = config.context ?: "."

    echo "Building ${imageName}:${imageTag}"

    sh """
        docker build \
        -t ${imageName}:${imageTag} \
        -t ${imageName}:latest \
        -f ${dockerfile} \
        ${context}
    """
}
