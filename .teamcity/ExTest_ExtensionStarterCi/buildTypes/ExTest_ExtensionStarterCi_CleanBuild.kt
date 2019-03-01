package ExTest_ExtensionStarterCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

/**
 * @author Satish Muddam
 */
object ExTest_ExtensionStarterCi_CleanBuild : BuildType({
    uuid = "77F19EFC-1147-4A08-B068-2616454F7590"
    id = "ExTest_ExtensionStarterCi_CleanBuild"
    name = "CleanBuild"

    vcs {
        root(ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter)
    }

    steps {
        maven {
            goals = "clean install -Pno-integration-tests"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
    }

    triggers {
        vcs {
        }
    }
})
