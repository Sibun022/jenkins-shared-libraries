def call() {

    echo "Running OWASP Dependency Check"

    dependencyCheck(
        additionalArguments: '''
            --scan .
            --format HTML
            --format XML
            --exclude node_modules
            --exclude .git
            --failOnCVSS 7
        ''',
        odcInstallation: 'OWASP'
    )

    dependencyCheckPublisher(
        pattern: '**/*dependency-check-report.xml'
    )
}
