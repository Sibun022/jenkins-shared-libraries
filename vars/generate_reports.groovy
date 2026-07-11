def call() {

    archiveArtifacts artifacts: '**/*.html', fingerprint: true

    archiveArtifacts artifacts: '**/*.xml', fingerprint: true

}
