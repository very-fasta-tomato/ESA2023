В данном проекте был выбран Spring Rest.

Лабораторная работа 3 является продолжением лр 2.

Предметная область - Хранилище постов соц. сети.
Структура таблиц:

Table users:

| id  | username |  
|-----|----------|
|     |          |
|     |          |
|     |          |
TABLE posts:

| id  | title | content | user_id |
|-----|-------|---------|---------|
|     |       |         |         |
|     |       |         |         |
|     |       |         |         |

Были реализованы Rest controllers, которые формировали ответ в виде xml или json, при указании Accept: application/json или application/xml.

Точки доступа для всех методов http - [GET, POST, PUT, DELETE]:
* /api/user
* /api/user/{id}
* /api/post
* /api/post/{id}

С помощью JAXB была сгенерирована xml schema объектов для применения к ней XSL-преобразования.

Было создано XSLT преобразование в файлах директории /.../xsl/

Точки доступа к представлениям
* /xsl/user
* /xsl/post

