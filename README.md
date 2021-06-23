## This is example simple rest service. 

## Requirements:
- Use any *object-oriented language* .
- Create endpoints for user.
- Create endpoints for tasks.
- Create automation scripts for testing.
- Add Report.

**Note**: please put your code in public repository.

**Note**: Please send link to this repo when you are done.

You will need the following technologies available to try it out:
* Git
* Spring Boot  
* Gradle 3+
* JDK 8
* IDE of your choice
* Web browser Chrome

### You can open service at:

``` http://http://localhost:8080/```

### For get info about user:
``` http://http://localhost:8080/user?id=1```

### For create new user using POST:
``` http://http://localhost:8080/create```  

### In the body use:
{
  "username": "user100",
  "password": "pass"
}

### For delete user using DELETE:
``` http://http://localhost:8080/remove/1```

### How to run automation scripts:

```./gradlew clean test -Denv=local```

### Generate Allure report

```./gradlew allureReport```

### Open Allure report in browser

```./gradlew allureServe```

![]()

![]()

![]()



