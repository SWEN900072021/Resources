## Step 4: Create Project in IntelliJ

---

> First confirm you have a Java Virtual Machine (JVM) installed on your machine. For Macs, the JVM can normally be found 
in the following directory: {Macintosh HD}/Library/Java/JavaVirtualMachines. If there is no JVM installed on your 
machine, please download one first before attempting these steps.

Launch IntelliJ and select New Project:

![](screenshots/4_create_project_1.png)

Select Java Enterprise and enter the information as shown below.

> Make sure you create the project in a directory you will remember. You will need to push it to GitHub.

![](screenshots/4_create_project_2.png)

> IntelliJ comes bundled with Java Enterprise Edition. If it's not in this list, it means the installation was likely 
corrupted. Try uninstalling and re-installing IntelliJ.

In the same window, select New to create a new Application Server:

![](screenshots/4_create_project_3.png)

Select Tomcat Server:

![](screenshots/4_create_project_4.png)

Select Browse:

![](screenshots/4_create_project_5.png)

Navigate to wherever you unzipped the Tomcat server you downloaded in step 2. Select the outermost folder then select 
Open:

![](screenshots/4_create_project_6.png)

Select OK:

![](screenshots/4_create_project_7.png)

Select Next:

![](screenshots/4_create_project_8.png)

Make sure Servlet is selected then select Finish:

![](screenshots/4_create_project_9.png)

IntelliJ will create a HelloWorld Servlet project by default.

> Once IntelliJ has finished creating the project (this could take a minute or more), you should test Tomcat has 
been set up successfully.

In the upper-right corner, select Run on the Tomcat configuration:

![](screenshots/4_create_project_10.png)

<details>
<summary>If you cannot select run configuration</summary>

Select Add Configuration:

![](screenshots/6_github_clone_4.png)

Add a new TomCat local configuration:

![](screenshots/6_github_clone_5.png)

Select Configure (Application Server may or may not already be populated - ignore it):

![](screenshots/6_github_clone_6.png)

Select the Open icon:

![](screenshots/6_github_clone_7.png)

Select the folder where you unzipped the TomCat directory in [Step 2: Download Tomcat](2_tomcat_download.md):

![](screenshots/6_github_clone_8.png)

Select OK:
![](screenshots/6_github_clone_9.png)

Select Deployment:

![](screenshots/6_github_clone_10.png)

Select the Add icon:

![](screenshots/6_github_clone_11.png)

Select Artifact:

![](screenshots/6_github_clone_12.png)

Select demo:war exploded:

![](screenshots/6_github_clone_13.png)
> *A Web application can be deployed to the TomCat server as an exploded directory where files and folders are presented
in the file system as separate items. A WAR file is a Web Archive file. An exploded WAR file means the structure is the
exact same as an archive file but not zipped into an archive form.*

Select Apply then OK:

![](screenshots/6_github_clone_14.png)

</details>

The project should be deployed to localhost:

![](screenshots/4_create_project_11.png)

To shut down the server, return to IntelliJ and select Stop:

![](screenshots/4_create_project_12.png)

---

> Please proceed to [Step 5: Setup GitHub Repository](5_github_setup.md).
