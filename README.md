# petstore
*To run from command line:*<br/>
1.clone the repository<br/>
2.go to the folder <br/>
3.open cmd<br/>
4.run the 'mvn clean install' command<br/>
*To run allure report from cmd:*<br/>
run this command $ allure serve target/allure-results<br/>

*To run from jenkins:*<br/>
#1.Install java jdk and add the path to enviromnent variable<br/>
#2.Install Jenkins.war<br/>
#3.Run Jenkins from cmd using 'java -jar jenkins.war'<br/>
#4.Open Localhos://8080<br/>
#5.Create user or login to Jenkins<br/>
#6.Creat new project<br/>
#7.In global configuration tool add Jdk ,maven ,allure report paths which are added in enviromnent variables and from plugins download allure report and html publisher <br/>
#8.Create new item<br/>
#9.Use free style project<br/>
#10.In source management Choose git and add repository url<br/>
#11.Add build step 'Invoke top-level maven targets'<br/>
#12.In goals add the command'clean install'<br/>
#13.Save <br/>
#14.Click on Build Now <br/>
