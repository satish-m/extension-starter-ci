package ExTest_ExtensionStarterCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

/**
 * @author Satish Muddam
 */
object ExTest_ExtensionStarterCi_StopLinux : BuildType({
    uuid = "92B5902C-E7F7-4CF4-8014-3882428D0234"
    id = "ExTest_ExtensionStarterCi_StopLinux"
    name = "Stop Linux docker"

    vcs {
        root(ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter)

    }

    steps {
        exec {
            path = "make"
            arguments = "dockerStop"
        }
    }

    dependencies {
        dependency(ExTest_ExtensionStarterCi_IntegrationTestInLinux) {
            snapshot {

            }
        }
    }

    triggers {
        vcs {
        }
    }
})