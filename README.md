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
  - git clone https://github.com/psj890729/api-test.git
  - cd api-test 
  - gradle wrapper 
  - ./gradlew clean test
  
  artifacts:
    when: always
    reports:
      junit: api-test/build/test-results/test/TEST-*.xml
    paths:
    - api-test/build/reports/
    expire_in: 1 week

  
```