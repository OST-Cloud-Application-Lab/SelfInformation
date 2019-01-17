App Engine Deployment (Java 8)
==============================

This guide explains how to configure our plan Spring Boot [Self Information](https://github.com/HSR-Cloud/SelfInformation/tree/master) application for a Google App Engine deployment.

## Prerequisites

The following software needs to be installed to follow this guide:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (for the cloud cli)

## Setup

* Initialize the Cloud SDK. You will be prompted to log-in with your Google account and to create a configuration and cloud project.

    `gcloud init`

* The project is just a blank project for now and not App Engine specific. Create the App Engine app:

    `gcloud app create`


## Maven

### Running

`mvn appengine:run`

Then visit http://localhost:8080/

### Deploying

`mvn appengine:deploy`

Then vist https://PROJECT-ID.appspot.com

### Stopping

* Stopping the app is done in two steps. First, we need to retrieve the version of the currently running app:

`gcloud app versions list`

```
SERVICE  VERSION          TRAFFIC_SPLIT  LAST_DEPLOYED              SERVING_STATUS
default  20190117t103106  1.00           2019-01-17T10:31:13+01:00  STARTED
```

* Using the version, the app can then be stopped:

`gcloud app versions stop 20190117t103106`

## Code and Configuration Changes

[Compare this branch to the master branch](https://github.com/HSR-Cloud/SelfInformation/compare/google-app-engine) to see the changes made for the App Engine deployment.