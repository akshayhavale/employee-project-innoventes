# employee-project-innoventes
EMPLOYEE PROJECT 


**PROJECT REUIREMENTS**
---------------------------------------

 1. STS(SPRING TOOL SUIT)
 2. JAVA(1.8 VERSION)
 3. MYSQL
 4. POSTMAN
 
**STEPS TO RUN THE APPLICATION**
 --------------------------------------- 

1. CLONE PROJECT FORM GIT BY USING **GIT CLONE+HTTP LINK** COMMAND TO YOUR SPECIFIC FOLDER.

2. ONCE THE PROJECT SETUP IS DONE, GO TO **src/main/resources** AND FIND A **application.properties**, WHERE NEED TO SET UP THE VALUES FOR
            1. spring.datasource.username=**YOUR-USERNAME**
            2. spring.datasource.password=**YOUR-PASSWORD**
            3. spring.datasource.url=jdbc:mysql://127.0.0.1:3306/**YOUR-DATABASENAME**?useSSL=false

3. ONCE THE 2ND STEP IS DONE THEN CLICK ON THE PROJECT RUN AS SPRING BOOT- APPLICATION, WHICH INTERNALLY DEVELOP THE TABLES.

4. IN FOLLOWING THESE THREE STEPS IF ANY ERROR OCCURS REGARDING DEPENDENCIES, THEN CLICK ON PROJECT MAVEN CLEAN AND MAVEN BUILD.

**STEPS TO PERFORM TESTING**
-------------------------------------------

NOTE :- IF WANT EASE TO FIND DETAILS OF ALL API AND JSON FOR REQUEST METHODS THEN TRY TO USE SWAGGER URL AS BELOW MENTIONED FOR THIS PROJECT ONCE THE PROJECT STARTED SUCCESSFULLY

SWAGGER URL :- http://localhost:8080/swagger-ui.html#/


IF THE ABOVE MENTIONED WON'T WORK THEN PLEASE FOLLOW BELOW MENTIONED DETAILS FOR TESTING USING POSTMAN

1. **TO CREATE EMPLOYEE**

METHOD - POST
URL - http://localhost:8080/api/v1/employee

REQUEST JSON - 
{
  "addresses": [
    {
      "addrLineOne": "string",
      "addrLineTwo": "string",
      "addressType": "string",
      "city": "string"
    }
  ],
  "dateOfBirth": "2020-07-20T07:11:08.841Z",
  "name": "string"
}

2. **TO PARTIAL UPDATE ON EMPLOYEE ADDRESS**

METHOD - PATCH
URL - http://localhost:8080/api/v1/update/address/employee/{empid}

NOTE: - PROVIDE PROPER ADDRESS ID IN THE JSON 
REQUEST JSON -
{
  "addresses": [
    {
      "addrLineOne": "string",
      "addrLineTwo": "string",
      "addressType": "string",
      "city": "string",
      "id": 0
    }
  ]
}

3. **TO GET EMPLOYEE DETAILS BY EMPLOYEE ID**

METHOD - GET
URL - http://localhost:8080/api/v1/employee/{empid}

4. **TO GET EMPLOYEE DETAILS BY EMPLOYEE NAME**

METHOD - GET
URL - http://localhost:8080/api/v1/employee/name/{name}

5. **TO GET ALL EMPLOYEE DETAILS **

METHOD - GET
URL - http://localhost:8080//api/v1/employee/all

6. **TO UPDATE EMPLOYEE DETAILS**

METHOD - PUT
URL - http://localhost:8080/api/v1/employee/{empid}

REQUEST JSON-
{
  "addresses": [
    {
      "addrLineOne": "string",
      "addrLineTwo": "string",
      "addressType": "string",
      "city": "string",
      "id": 0
    }
  ],
  "dateOfBirth": "2020-07-20T07:19:52.681Z",
  "id": 0,
  "name": "string"
}

7. **TO DELETE THE EMPLOYEE BY EMPLOYEE ID**

METHOD - DELETE 
URL - http://localhost:8080/api/v1/employee/{empid}







