def call() {
    dependencyCheck(
        additionalArguments: '''
            --scan .
            --format HTML
            --format XML
        ''',
        odcInstallation: 'OWASP'
    )
}

return this
