pipeline {
  agent any

 stages {
    stage('Build') {
      steps {
        git 'https://github.com/Leitax/rest-desafio-administra-personas.git'

                bat "mvn -Dmaven.test.failure.ignore=true clean package"
      }
    }
    stage('Scan') {
            steps {
                // Install trivy
                bat 'curl -sfL https://raw.githubusercontent.com/aquasecurity/trivy/main/contrib/install.sh | bat -s -- -b /usr/local/bin v0.18.3'
                bat 'curl -sfL https://raw.githubusercontent.com/aquasecurity/trivy/main/contrib/html.tpl > html.tpl'

                // Scan all vuln levels
                bat 'mkdir -p reports'
                bat 'trivy filesystem --ignore-unfixed --vuln-type os,library --format template --template "@html.tpl" -o reports/nodjs-scan.html ./nodejs'
                publishHTML target : [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'nodjs-scan.html',
                    reportName: 'Trivy Scan',
                    reportTitles: 'Trivy Scan'
                ]

                // Scan again and fail on CRITICAL vulns
                bat 'trivy filesystem --ignore-unfixed --vuln-type os,library --exit-code 1 --severity CRITICAL ./nodejs'

            }

  }
}
}