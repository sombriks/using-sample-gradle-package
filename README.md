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
            username = System.getenv("MY_USERNAME")
            password = System.getenv("MY_TOKEN")
        }
    }
}
//...
```

NOTE: for packages from private projects you must provide valid credentials (i.e. access to the private project)

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
it's up to you to create it.

You can create your github token on this url:

- <https://github.com/settings/tokens/new>

You can test if credentials are working fine with the following command

```kotlin
./gradlew :app:build-- refresh -dependencies
```
