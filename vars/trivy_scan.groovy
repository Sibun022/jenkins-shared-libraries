def call() {
    echo "Running Trivy Filesystem Scan"

    sh '''
        trivy fs . \
        --skip-version-check \
        --scanners vuln,secret \
        --severity HIGH,CRITICAL
    '''
}
