def call() {
    echo "Running Trivy Filesystem Scan"

    sh '''
        trivy fs . \
        --format table \
        --severity HIGH,CRITICAL
    '''
}
