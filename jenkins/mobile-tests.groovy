timeout(60) {
    node('maven-slave') {

        wrap([$class: 'BuildUser']) {
            currentBuild.description = """
                build user : $BUILD_USER
                branch : $BRANCH
            """

            params = readYaml text: env.YAML_CONFIG ?: null
            if (params != null) {
                for (param in params.entrySet()) {
                    env.setProperty(param.getKey(), param.getValue())
                }
            }
        }

        stage("Checkout") {
            checkout scm
        }

        stage("Create configurations") {
            sh "echo PLATFORM_NAME=${env.getProperty('PLATFORM_NAME')} > ./.env"
            sh "echo PLATFORM_VERSION=${env.getProperty('PLATFORM_VERSION')} >> ./.env"
        }

        stage("Build Docker image") {
            // Сборка Docker-образа
            sh "docker build -t mobile_tests:1.0.0 ."
        }

        try {
            stage("Run UI tests") {
                sh("rm -rf /root/mobile-allure/*")
                sh "docker run --rm --env-file ./.env -v m2:/root/.m2 -v mobile-allure:/home/unixuser/mobile_tests/allure-results -t mobile_tests:1.0.0"
            }
        }
        finally {
            stage("Publication of the allure report") {
                sh("mkdir ./allure-results")
                sh("cp /root/mobile-allure/* ./allure-results/")
                generateAllure()
            }
        }
    }
}

def generateAllure() {
    allure([
            includeProperties: true,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            results          : [[path: './allure-results']]
    ])
}
