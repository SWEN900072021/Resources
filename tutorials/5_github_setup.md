## Step 5: Setup GitHub Repository

---
Create a GitHub account [here](https://www.github.com), if you do not already have one.

Create a new repository for the project.
> *Make sure you set the repository as private* to avoid others plagiarising your work. You **will** be help responsible 
under the university's academic integrity policy if someone plagiarises off your work (even if you were unaware they were
plagiarising).  

Invite **all** the teaching staff of the subject* to the repository.
Their usernames are:

| Name | Username |
| --- | --- |
| Eduardo Oliveira | @agogear |
| Maria Read | @mariaars |
| Luke Rosa | @lukearosa |
| Samodha | @samodhap |

Once you have created a repository, open a terminal window. Navigate into the project you created in step 3.

Get the web URL of the repository you have created:
![](screenshots/5_github_setup_1.png)

Change "demo" to be whatever you named your repository:
````
echo "# demo" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
````

Change the URL to be the URL of your repository:
````
git remote add origin https://github.com/lukearosa/demo.git
git push -u origin main
git add .
git commit -m "create initial structure"
git push
````

Once done, your repository will have the project you have just created in IntelliJ.

---

> Please proceed to [Step 6: Clone GitHub Repository](6_github_clone.md).
