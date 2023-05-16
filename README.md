# using sample gradle package

sample project to consume the package from
[this project](https://github.com/sombriks/sample-gradle-package)

## working workflow

Add the repository url into build config

```kotlin
//...
repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/sombriks/sample-gradle-package")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}
//...
```

Add the dependency

```kotlin
//...
dependencies {
    // other dependencies

    implementation("sample.gradle.mylibrary:lib:0.1.2-SNAPSHOT")
}
//...
```

Create the environment variables `GITHUB_ACTOR` and `GITHUB_TOKEN` with your
github credentials and make it available for gradle

Those variables are created by github itself to be used in actions but locally
it's up to you to proper create it.

You can create your github token on this url:

- <https://github.com/settings/tokens/new>
