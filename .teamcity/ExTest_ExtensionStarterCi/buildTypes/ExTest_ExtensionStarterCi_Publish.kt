package ExTest_ExtensionStarterCi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

/**
 * @author Satish Muddam
 */

object ExTest_ExtensionStarterCi_Publish : BuildType({
    uuid = "7D738675-AB95-43FB-86CF-963C9E45B6FB"
    id = "ExTest_ExtensionStarterCi_Publish"
    name = "Publish build artifact"

    vcs {
        root(ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter)
    }

    steps {
        maven {
            goals = "github-release:release"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
    }

    dependencies {
        dependency(ExTest_ExtensionStarterCi_StopLinux) {
            snapshot {

            }
        }
    }

    triggers {
        vcs {
        }
    }


    artifactRules = """
       target/ApacheMonitor-*.zip
    """.trimIndent()

})