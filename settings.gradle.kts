pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://repo.huaweicloud.com/repository/maven/") }
        maven { setUrl("https://jitpack.io") }
        // maven { setUrl("https://maven.scijava.org/content/repositories/public/") }
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://repo.huaweicloud.com/repository/maven/") }
        maven { setUrl("https://jitpack.io") }
        // maven { setUrl("https://maven.scijava.org/content/repositories/public/") }
        // GitHub Packages (compose-miuix-ui/miuix)
        //
        // NOTE:
        // GitHub Packages does NOT support anonymous access.
        // Even if the repository is public or you are a member of the organization,
        // authentication is still required to resolve dependencies.
        //
        // Required environment variables (recommended):
        //   - GITHUB_ACTOR : your GitHub username
        //   - GITHUB_TOKEN : a Personal Access Token (classic) with `read:packages` scope
        //
        // Alternative:
        //   - Define `gpr.user` and `gpr.key` in ~/.gradle/gradle.properties (NOT in this repo)
        //
        // This configuration is intentionally placed in settings.gradle.kts
        // to work with RepositoriesMode.FAIL_ON_PROJECT_REPOS.
        val gprUser = providers.gradleProperty("gpr.user")
            .orElse(providers.environmentVariable("GITHUB_ACTOR"))
            .getOrElse("")
        val gprKey = providers.gradleProperty("gpr.key")
            .orElse(providers.environmentVariable("GITHUB_TOKEN"))
            .getOrElse("")
        if (gprUser.isNotBlank() && gprKey.isNotBlank()) {
            maven {
                url = uri("https://maven.pkg.github.com/compose-miuix-ui/miuix")
                credentials {
                    username = gprUser
                    password = gprKey
                }
            }
        }
    }
}

rootProject.name = "InstallerX-Revived"
include(
    ":app",
    ":hidden-api"
)
