def call() {
    echo "Running Trivy Filesystem Scan"

    sh '''
        trivy fs .
    '''
}
