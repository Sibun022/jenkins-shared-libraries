def call() {

    echo "Running OWASP Dependency Check"

    dependencyCheck(
        additionalArguments: '''
            --scan .
            --format HTML
            --format XML
        ''',
        odcInstallation: 'OWASP'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
