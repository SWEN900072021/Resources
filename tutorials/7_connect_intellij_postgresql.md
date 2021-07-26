## Step 7: Connect IntelliJ Project to Local PostgreSQL Instance

---

To connect the project to the local instance of PostgreSQL, open the Database view:

![](screenshots/7_connect_intellij_postgresql_1.png)

Select 'New':

![](screenshots/7_connect_intellij_postgresql_2.png)

Select 'PostgreSQL':

![](screenshots/7_connect_intellij_postgresql_3.png)

Enter the details of your local PostgreSQL instance:

![](screenshots/7_connect_intellij_postgresql_4.png)

Select 'Test Connection' to test the details you entered are correct:

![](screenshots/7_connect_intellij_postgresql_5.png)

Select 'OK':

![](screenshots/7_connect_intellij_postgresql_6.png)

The console will open. Run an SQL query to make sure the database has been connected successfully. Enter any query and select 'Run':

![](screenshots/7_connect_intellij_postgresql_7.png)

If successful, there will be a tick next to the SQL query, and it will display the query in the console:

![](screenshots/7_connect_intellij_postgresql_8.png)

The newly created table should be viewable in pgAdmin:

![](screenshots/7_connect_intellij_postgresql_9.png)

---

> The next step is to deploy the application to Heroku. This does not need to be done now - in fact we recommend you 
> begin developing the application prior to deployment.
> However, if you wish to proceed now please proceed to [Step 8: Deploy Project to Heroku](8_heroku_deploy.md).
