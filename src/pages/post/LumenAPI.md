---
layout: ../../layouts/PostLayout.astro
title: Create API with Lumen Framework
image: /images/postImages/lumenAPI/lumen.jpg
date: 2022-09-05 00:00
categories:
  - php
  - lumen
---

**CREATE SIMPLE CRUD REST API WITH LUMEN FRAMEWORK**

In this article we will create simple **CRUD** APIs using Lumen Framework, MySQL & Eloquent ORM. This tutorial is about the backend implementation and I will explain the concepts and implementation step by step.

**. &nbsp;** **. &nbsp; .**

**LUMEN MICRO-FRAMEWORK**

**`Lumen`** is a open-source PHP micro-framework created as an alternative to the `Laravel Framework`. The Specialty of this is when you want to create only APIs, you won't need lots of Laravel default libraries / dependencies. In that case, here comes the Lumen, a micro-framework which utilized Laravel's best parts with light weight and faster execution time.

**PREREQUISITES**

**Tools**

- ○ PHP 7.2 or Higher
- ○ Composer
- ○ MySQL Server & PHPMyAdmin
- ○ Postman

**knowledge**

- ○ PHP knowledge
- ○ A bit of Laravel knowledge.
- ○ SQL knowledge (would be helpful).

**. &nbsp;** **. &nbsp; .**

**CREATING THE PROJECT**

To create a project, simply open your command line tool and execute the following command. Don't forget to replace `'your-project-name'` with your actual project name.

<pre>

</pre>

---

&nbsp; `composer create-project --prefer-dist laravel/lumen your-project-name`

---

<pre>

</pre>

Once the project is created you can change your directory to the project directory and run following command to start the server.

<pre>

</pre>

---

&nbsp; `php -S localhost:8000 -t public`

---

<pre>

</pre>

You can test the endpoint using **Postman** by sending a **GET** request to the "/" route.

<pre>
</pre>

![postman/](/images/postImages/lumenAPI/1.png)

**. &nbsp;** **. &nbsp; .**

**DATABASE CONFIGURATION**

To create a database in MySQL server, you can use the PHPMyAdmin. I'll show you how to create a database with the command line.
I'll take the database name as `'lumen_product'`.

![MySQL](/images/postImages/lumenAPI/2.png)

Once you done with the database, you can open the project with you favorite code editor and open **`.env`** file and do the configurations.

![.env](/images/postImages/lumenAPI/3.png)

The next step is to create database migration. Unlike laravel, you can't use **`make:model`** with **-m** option to automatically generate model and the migration in lumen. So i will create the `Migration` first and later I will create the `Model`.

<pre>

</pre>

---

&nbsp; `php artisan make:model create_product_table`

---

<pre>

</pre>

The above command will create a migration file with the name given before **`create_product_table`** inside **`database/migrations`** directory.

Now we can create the product schema. Open the created migration file and add some basic data fields inside the **`CreateProductTable`** class, inside the **`public function up()`**.
- ○ Name
- ○ Price
- ○ Category





