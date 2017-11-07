### Simple Spring Boot CLI for testing AWS Connectivity

You may need to setup AWS credentials using AWS CLI or manually. 
Follow [this page](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html) for step by step instructions.

Also make sure that the IAM account has permissions to list SQS queues.

#### Building

```
mvn clean package
```

#### Running 

```
AWS_REGION="<region-name>" AWS_PROFILE="<profile-name>" java -jar target/aws-cli-runner-1.0.jar
```

