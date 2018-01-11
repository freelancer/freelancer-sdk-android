# Freelancer Android Sdk

The Freelancer sdk aims to make using the the Freelancer.com API as easy as possible.


## Freelancer sdk features

* Easy access to accounts.freelancer.com for OAuth to the Freelancer.com API
* Containts models for all json response
* Access the Freelancer.com API

## Getting Started

* Create a new client application on the [Freelancer.com developer portal](https://accounts.freelancer.com/settings/develop)
* Install Freelancer android sdk using the instructions below.

### Install using Bintray JCenter

Add freelancer dependency to your build.gradle:
```groovy
//In the root build.gradle file
allprojects {
    repositories {
        //ensure you have this line in you repositories for all projects
        jcenter()

        maven {
            url  "https://dl.bintray.com/freelancer/freelancer-sdk-android"
        }
    }
}

//In the project gradle
dependencies {
    compile('com.freelancer:freelancer-sdk:0.1.5@aar') {
        transitive = true
    }
}

```

Please check the [SampleActivity](https://github.com/freelancer/freelancer-sdk-android/blob/master/sample/src/main/java/com/freelancer/android/flsdkandroid/SampleActivity.kt) for usage examples


## Contributing

The master branch of this repository is used for developing, releases will be cut from the master branch, any fixes for these release will be created on master and cherry picked onto the release branches. To contribute please create a fork from master and submit a pull request.


## Contact

For usage questions please check through the issues and check the [sample app](https://github.com/freelancer/freelancer-sdk-android/blob/master/sample/src/main/java/com/freelancer/android/flsdkandroid/SampleActivity.kt).
If you are still having problems please post an issue [here](https://github.com/freelancer/freelancer-sdk-android/issues).

Please report any bugs as [issues](https://github.com/freelancer/freelancer-sdk-android/issues).

## License

Licensed under the [GNU Lesser General Public License v3.0](https://github.com/freelancer/freelancer-sdk-android/blob/master/LICENSE)
