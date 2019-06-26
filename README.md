# ABC Message Board Application.
## this application is targeted at creating a public messaging forum where 
1. Users will be able to view the list of Headings available such as 'Arts & Entertainment',
  'Innovation & Tech', 'Society' etc.
2. Users will be able to post/view a 'Topic' under any of the selected 'Heading'.
3. Users will be able to post/view a 'Post' under any of the selected 'Topic'.
4. Users will be able to comment/like a 'Post'.

## Main building blocks
 * Spring Boot 2.1.6.RELEASE, Spring JPA
 * H2 Database Engine
 * Swagger - Web client to test rest api's
 * Junit and mockito test
 * Maven


## To run the application
1. Clone the repository by opening Git Bash and type git clone, and then paste the URL or clone the
repository from GitHub desktop. On GitHub desktop, navigate to the main page of the repository
and clone the repository in Desktop. Follow the prompts in GitHub Desktop to complete the clone.
2. $ git clone <URL>
3. Press Enter. Local clone will be created.
4. Maven -> Update project to update the project dependencies.
6. Run the command mvn clean install to build the project.
7. Run the MessageBoardApplication.java as ‘Java Application’
8. Go to swagger url ‘http://localhost:8080/swagger-ui.html#/’.


## To test the application

1. Start the application.
2. Go to swagger url ‘http://localhost:8080/swagger-ui.html#/’.
3. Test the api’s for Heading (Get), Topic (Get, Post, Put, Delete), Post (Get, Post, Put, Delete), Comment
(Get, Post, Put, Delete). The sample input and other information required to use the api’s are available in
api documentation.
