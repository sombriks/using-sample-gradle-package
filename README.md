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

Add the dependency

```kotlin
//...
dependencies {
    // other dependencies

    implementation("sample.gradle.mylibrary:lib:0.1.2-SNAPSHOT")
}
//...
```

Create the environment variables `MY_USERNAME` and `MY_TOKEN` with your
github credentials and make it available for gradle.

You can create your github token on this url:

- <https://github.com/settings/tokens/new>

You can test if credentials are working fine with the following command

```bash
# make sure MY_USERNAME and MY_TOKEN are present as environment variables
./gradlew :app:build --refresh-dependencies
```

if you have any github actions then those variables must be set on them in
order to proper build the project. create them as
[github secrets](https://docs.github.com/en/actions/security-guides/encrypted-secrets#accessing-your-secrets).
