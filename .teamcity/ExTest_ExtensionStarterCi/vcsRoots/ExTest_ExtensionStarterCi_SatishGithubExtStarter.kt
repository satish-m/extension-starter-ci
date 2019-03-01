package ExTest_ExtensionStarterCi.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object ExTest_ExtensionStarterCi_SatishGithubExtStarter : GitVcsRoot({
    uuid = "5d76acd1-a7df-466a-af5e-eb76462890f2"
    name = "SatishGithub-ExtStarter"
    url = "git@github.com:satish-m/extension-starter-ci.git"
    authMethod = uploadedKey {
        uploadedKey = "Satish-Github"
        passphrase = "credentialsJSON:ff8c81a2-cc0c-469e-950d-6ea1fca07eb3"
    }
})
