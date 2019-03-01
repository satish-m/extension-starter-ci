package ExTest_ExtensionStarterCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

/**
 * @author Satish Muddam
 */
object ExTest_ExtensionStarterCi_IntegrationTestInLinux : BuildType({
    uuid = "5389CC2C-00E4-4DAC-B76F-E8A3D9633771"
    id = "ExTest_ExtensionStarterCi_IntegrationTestInLinux"
    name = "IntegrationTest in Linux"

    vcs {
        root(ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter)

    }

    steps {
        maven {
            goals = "clean install"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
    }

    dependencies {
        dependency(ExTest_ExtensionStarterCi_SetupInLinux) {
            snapshot {

            }
        }
    }

    triggers {
        vcs {
        }
    }
})