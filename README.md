[![Build Status](https://travis-ci.org/freelancer/freelancer-sdk-android.svg?branch=master)](https://travis-ci.org/freelancer/freelancer-sdk-android)

# Freelancer Android SDK

The Freelancer sdk aims to make using the Freelancer.com API as easy as possible.


## Features

* Easy access to accounts.freelancer.com for OAuth to the Freelancer.com API
* Contains models for all json response
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
    }
}

//In the project gradle
dependencies {
    compile 'com.freelancer:android-sdk:0.1.0'
}
```

Please check the [SampleActivity](https://github.com/freelancer/freelancer-sdk-android/blob/master/sample/src/main/java/com/freelancer/android/flsdkandroid/SampleActivity.kt) for usage examples.

## Contributing

To contribute please create a fork from master and submit a pull request.

## Contact

For usage questions please check through the [issues](https://github.com/freelancer/freelancer-sdk-android/issues) and check the [sample app](https://github.com/freelancer/freelancer-sdk-android/blob/master/sample/src/main/java/com/freelancer/android/flsdkandroid/SampleActivity.kt).

## Report Issues

Please report any issue/s encountered when using the SDK [here](https://github.com/freelancer/freelancer-sdk-android/issues/new/choose).

## License

Licensed under the [GNU Lesser General Public License v3.0](https://github.com/freelancer/freelancer-sdk-android/blob/master/LICENSE).
