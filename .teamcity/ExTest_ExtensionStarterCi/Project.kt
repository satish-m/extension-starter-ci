package ExTest_ExtensionStarterCi

import ExTest_ExtensionStarterCi.buildTypes.ExTest_ExtensionStarterCi_CleanBuild
import ExTest_ExtensionStarterCi.buildTypes.ExTest_ExtensionStarterCi_IntegrationTestInLinux
import ExTest_ExtensionStarterCi.buildTypes.ExTest_ExtensionStarterCi_SetupInLinux
import ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({

    uuid = "B6EFD8B0-63F1-4FE8-AB4F-1734BD19AF8E"
    id = "ExTest_ExtensionStarterCi"
    parentId = "ExtensionsTest"
    name = "extension-starter-ci"

    vcsRoot(ExTest_ExtensionStarterCi_SatishGithubExtStarter)

    buildType(ExTest_ExtensionStarterCi_CleanBuild)
    buildType(ExTest_ExtensionStarterCi_SetupInLinux)
    buildType(ExTest_ExtensionStarterCi_IntegrationTestInLinux)
    //buildType(ExTest_ExtensionStarterCi_StopLinux)
    //buildType(ExTest_ExtensionStarterCi_Publish)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = "${ExTest_ExtensionStarterCi_SatishGithubExtStarter.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }

    buildTypesOrder = arrayListOf(
            ExTest_ExtensionStarterCi_CleanBuild,
            ExTest_ExtensionStarterCi_SetupInLinux,
            ExTest_ExtensionStarterCi_IntegrationTestInLinux
            //ExTest_ExtensionStarterCi_StopLinux
            //ExTest_ExtensionStarterCi_Publish
    )
})
