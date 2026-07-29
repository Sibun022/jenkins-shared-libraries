def call() {

    echo "===================================="
    echo "Running OWASP Dependency Check"
    echo "===================================="

    withCredentials([
        string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
    ]) {

        dependencyCheck(
            additionalArguments: """
                --scan .
                --format HTML
                --format XML
                --exclude node_modules
                --exclude .git
                --failOnCVSS 7
                --nvdApiKey ${NVD_API_KEY}
                --disableAssembly
            """,
            odcInstallation: 'OWASP'
        )
    }

    echo "Publishing OWASP Dependency Check Report"

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )

    echo "===================================="
    echo "OWASP Dependency Check Completed"
    echo "===================================="
}
