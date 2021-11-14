# Rested App Overview
The Rested App has been created for the QA bootcamp practical project. 

## Rested App Proposed Features (M = main feature, A = adventurous personal stretch-goal feature)
- Track daily sleep data. M
- Track daily screen time. M
- Track water consumption. M
- Weekly reports of user data. M
- Rate sleep quality and make records in dreams journal (user inputted data). M
- Cat Nap vs Night Mode. A
 - Cat Nap mode enters a sleep mode for 25 minutes (using timer/alarm integration), app records and adds all Cat Naps to weekly report
 - Night Mode records expected majority of user's sleep (daily sleep = tracked sleep using timer minus total user absences (minutes) from the night mode)
- Integration with music and podcast streaming services (spotify/apple music integration). A

# Risk Assessment
This outlines the potential issues and risks faced during this project's timeline.

| Description                             |Evaluation                       |Likelihood     |Impact Level |Responsibility |Response       | Control Measures                |
|-----------------------------------------|---------------------------------|---------------|-------------|---------------|---------------|---------------------------------| 
| No mySQL connection                     | DB doesn't show tables          | High          | High        |  Dev          | Fix           |Use Eclipse DB perspective       |
| No Postman connection                   | API calls fail                  | Medium        | High        |  Dev          | Fix           |Ensure port not used by other app|
| Poor JUnit test coverage                | Can't reach 60%                 | High          | High        |  Dev          | Fix           |Test ASAP                        |
| Poor Integration test coverage          | Can't reach 60%                 | High          | High        |  Dev          | Fix           |Test ASAP                        |
| Too many features                       | Extra features bring more bugs  | Medium        | Medium      |  Dev          | Delete excess | Use git to manage               |

## Must Have
### Codebase
- Spring Boot API with full CRUD functionality.
- Sensible package structure (back-end).
- Adherence to best practices.
### Testing
- Unit and integration testing for the project back-end.
- Reasonable test coverage of the src/main/java folder.
### Continuous Integration
- GitHub repository utilising the feature-branch model
- The main branch must compile
- A build of the application is present in the root folder of your git repo
 - A .jar which can be deployed from the command-line (java -jar <filename.jar>)
### Repository & Documentation
- A completed project management board, including user stories, acceptance criteria, estimations via story points, and prioritisation via MoSCoW methodology. You must add Ed as collaborators on your Jira board.
- A working .gitignore for ignoring build-generated files and folders
- You are also expected to make a README.md file and to fill this README with information about this project. It should contain the following headers:
 - Why are we doing this?
 - How I expected the challenge to go.
 - What went well? / What didn't go as planned?
 - Possible improvements for future revisions of the project.
 - Screenshots showing your postman requests and the output from the API.
 - Screenshots of your database to prove that data is being persisted.
 - Screenshot of your test results, including coverage report.
 - Link to Jira Board - You must add Ed as collaborators on your Jira board.
- A documentation folder containing:
 - A completed risk assessment, utilising a matrix, in .pdf format 

## Should Have 
-  
## Could Have
- Create an ERD diagram for your specified domain and include it in the documentation folder.
- Use custom queries, such as ‘find by name’.
- Include custom exceptions in your service.
- Include the use of DTOs
- Include the use of Lombok
- Implement Mockito
- Achieve 80% test coverage of the src/main/java folder.

## Won't Have
- Too many features
- Frontend
- Web Tokens

## Jira Board
A combination Jira board using Scrum and Kanban features was used for the software development cycle of the Rested App.
> **See Here:** The link to the **Jira board** for this project is just a [click](https://qadfesw3.atlassian.net/jira/software/projects/DPP/boards/1) away. 

# Why this project is being built

The Rested App is being built to meet the Practical Project requirements for the QA DfE software developer bootcamp. The project encapsulates the skills taught during the nine week programme.


# How I expected the challenge to go

I expected the challenge to be difficult to complete due to the large number of elements required in the brief.

# What went well? / What didn't go as planned?
## What went well
- Creation of request and response mapping
- Creation of domain files
- Creation of services
- Creation of repos

## What didn't go as planned
- Planning the work effectively to complete everything within the deadline
- The testing (especially unit testing)
- Connection to Postman and mySQL not working 

# Possible improvements for future revisions of the project.
- Only spend one day on planning, start with pen and paper first!
- Leave more time for testing.
- Less is more, start with less features and don't waste time trying to perfect what may end up redundant. 

# Screenshots showing your postman requests and the output from the API.

![image](https://user-images.githubusercontent.com/61471777/141701881-63e36024-6bc4-4559-9853-8f35ed9d3de0.png)

# Screenshots of your database to prove that data is being persisted.

![image](https://user-images.githubusercontent.com/61471777/141701946-7c2cb958-40f8-4591-a981-45bc3c2a4bd1.png)

![image](https://user-images.githubusercontent.com/61471777/141701964-47e62af4-8da5-47c2-8055-d8660efea59b.png)

# Screenshot of your test results, including coverage report.

![image](https://user-images.githubusercontent.com/61471777/141702087-2a9caaf7-d8d0-4f93-a296-c0f4e961ec1a.png)

![image](https://user-images.githubusercontent.com/61471777/141702406-625f9fb3-f474-4310-905c-838f30ebcd26.png)

