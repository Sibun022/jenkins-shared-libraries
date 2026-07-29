def call() {
    dependencyCheck(
        odcInstallation: 'OWASP',
        additionalArguments: '''
            --scan .
            --format HTML
            --format XML
        '''
    )
}

return this
