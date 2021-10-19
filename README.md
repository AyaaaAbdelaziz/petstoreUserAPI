# petstore
*To run form command line:*
#1.clone the repository
#2.go to the folder 
#3.open cmd
#4.run the 'mvn clean install' command
#To run allure report from cmd:
#run this command $ allure serve target/allure-results

*To run from jenkins:*
#1.Install java jdk and add the path to enviromnent variable
#2.Install Jenkins.war
#3.Run Jenkins from cmd using 'java -jar jenkins.war'
#4.Open Localhos://8080
#5.Create user or login to Jenkins
#6.Creat new project
#7.In global configuration tool add Jdk ,maven ,allure report paths which are added in enviromnent variables and from plugins download allure report and html publisher 
#8.Create new item
#9.Use free style project
#10.In source management Choose git and add repository url
#11.Add build step 'Invoke top-level maven targets'
#12.In goals add the command'clean install'
#13.Save 
#14.Click on Build Now 
