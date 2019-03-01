package ExTest_ExtensionStarterCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

/**
 * @author Satish Muddam
 */
object ExTest_ExtensionStarterCi_SetupInLinux : BuildType({
    uuid = "87F20D7A-EC67-4CFB-BD56-BCEDE59D7DB6"
    id = "ExTest_ExtensionStarterCi_SetupInLinux"
    name = "Setup Linux Environment"

    vcs {
        root(ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter)

    }

    steps {
        exec {
            path = "make"
            arguments = "dockerRun"
        }

        //Waits for 5 minutes to send metrics to the controller
        exec {
            path = "make"
            arguments = "sleep"
        }
    }

    dependencies {
        dependency(ExTest_ExtensionStarterCi_CleanBuild) {
            snapshot {

            }
        }
    }

    triggers {
        vcs {
        }
    }
})