package ExTest_ExtensionStarterCi

import ExTest_ExtensionStarterCi.vcsRoots.*
import ExTest_ExtensionStarterCi.vcsRoots.ExTest_ExtensionStarterCi_SatishGithubExtStarter
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_2.projectFeatures.versionedSettings

object Project : Project({
    id("ExTest_ExtensionStarterCi")
    parentId("ExtensionsTest")
    name = "extension-starter-ci"
    description = "extension-starter-ci"

    vcsRoot(ExTest_ExtensionStarterCi_SatishGithubExtStarter)

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
})
