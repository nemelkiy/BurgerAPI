# Технологии разработки программного обеспечения <br>
## Лабораторная работа №1
Разработка микросервиса (REST API) на Springboot с БД
- Выполнил: Коломиченко А.Н.
- Группа: МБД 2131
- Задачи работы: Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
### Как запустить проект?
- Склонировать проект с репозитория

`$ git clone https://github.com/nemelkiy/BurgrshopApi`

##### Запуск Docker-контейнера с базой данных
- Перейти в директорию базы данных

`$ cd src\main\resources\DataBase`

- Собрать Docker контейнер с базой данных

`$ docker build . -t postgres:latest`

- Запустить Docker контейнер с базой данных PostgreSQL

`$ docker run -p 5432:5432 postgres:latest`

##### Запуск приложения

- Сборка при помощи Maven из командной строки

`$ mvnw package`

- Сборка Docker образа

`$ docker build . -t burgerapi:latest`

- Запуск Docker контейнера c с приложением

`$ docker run -p 5433:5433 burgerapi:latest`

### Пример запросов к API

- Проверка статуса работы (Получение имени хоста)

Тип запроса: `GET` `http://localhost:8080/api/v1/status`

- Получение всех записей из базы данных

Тип запроса: `GET` `http://localhost:8080/api/v1/product`

- Получение записи из базы данных по известному id

Тип запроса: `GET` `http://localhost:8080/api/v1/product/3`

- Запись в базу данных нового продукта

Тип запроса: `POST` `http://localhost:8080/api/v1/product/`

Тело запроса (JSON): `{"name": "Брут", "weight": 300, "price": 350, "category": "Бургеры" }`

- Изменение параметров продукта в базе данных по известному id

Тип запроса: `PUT` `http://localhost:8080/api/v1/product/7`

Тело запроса (JSON): `{"name": "БрутМакс", "weight": 370, "price": 550, "category": "Бургеры" }`

- Удаление записи из базы данных по известному id

Тип запроса: `DELETE` `http://localhost:8080/api/v1/product/7`
