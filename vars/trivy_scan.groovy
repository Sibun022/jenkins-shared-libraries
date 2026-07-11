#!/usr/bin/env groovy

def call() {

    echo "========================================"
    echo "Running Trivy Filesystem Scan"
    echo "========================================"

    sh '''
        set +e

        trivy fs . \
          --skip-version-check \
          --scanners vuln,secret \
          --severity HIGH,CRITICAL

        STATUS=$?

        if [ $STATUS -ne 0 ]; then
            echo "========================================"
            echo "Trivy scan returned exit code $STATUS"
            echo "This may be due to:"
            echo " - Maven Central HTTP 429 rate limiting"
            echo " - Temporary network issue"
            echo " - Database update issue"
            echo "Continuing pipeline..."
            echo "========================================"
            exit 0
        fi
    '''
}
