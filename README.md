
# gradle run
```
# base url 넣어야 함
gradle wrapper
./gradlew clean test
```

# docker run
```
cd api-test
docker build -t api-test:1.0 .
docker run -t api-test:1.0
```


# .gitlab-ci.yml
```
image: psj890729/api-test:0.1

stages:
- test

before_script:
- echo "before script"


after_script:
- echo "after script"

# job 
job_1:
  stage: test
  only:
  - master
  script:
  - gradle test 
  
  artifacts:
    when: always
    reports:
      junit: /build/test-results/test/TEST-*.xml
    paths:
    - /build/reports/
    expire_in: 1 week


java3:
  stage: test
  script:
  - gradle test --tests *sampleTest
  artifacts:
    reports:
      junit: build/test-results/test/TEST-*.xml
  tags:
  - apitest
```

```
# docker in docker
image: docker:git
services:
- docker:dind


stages:
- build
- test

before_script:
- #script...

job1:
  stage: build
  script:
  - #script...
  
job2:
  stage: test
  script:
  - #script...

```