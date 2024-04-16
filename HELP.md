# Учет студентов
## Автор
### Общее
Программа была написана студентом школы [SkillBox](https://skillbox.ru/) Андриенко Виталием.
Практическое задание курса Разработка на Spring Framework.
Модуль 2 Spring Boot
## Документация
### Описание
Программа предназначена для учета студентов. Позволяет вести список студентов с указанием фамилии, имени и возраста.
Представляет из себя консольное приложение, которое упровляется с помощью команд консоли.
### Первый запуск
Можно инициализировать приложение с начальным списком студентов. 
Для этого создайте файл students.txt в корне приложения с начальным списком студентов в формате csv, содержащие строки:
* Петров;Николай;18
* Василькова;Мария;19
* ...

Также в свойствах (application.properties) должен быть указан профиль init:
* spring.profiles.active=init
### Команды
* show (Выводит список студентов)
* add --firstName Селезнева --lastName Алиса --age 55 (Добавляет студента)
* del --id 2 (Удаляет студента с номером 2)
* delAll (Удаляет всех студентов)
## Используемые технологии
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Spring Shell](https://spring.io/projects/spring-shell)

