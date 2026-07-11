def call(Map config = [:]) {

    def frontendTag = config.frontendTag
    def backendTag = config.backendTag

    sh """

    sed -i 's|image: biswa022/wanderlust-frontend-beta:.*|image: biswa022/wanderlust-frontend-beta:${frontendTag}|g' k8s/frontend.yaml

    sed -i 's|image: biswa022/wanderlust-backend-beta:.*|image: biswa022/wanderlust-backend-beta:${backendTag}|g' k8s/backend.yaml

    """

    sh """
        git add k8s/

        git commit -m "Updated image tags"

        git push
    """
}
