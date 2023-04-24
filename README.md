# cinema_base

## Документация

## 1. Запуск проекта

В пропертях проекта для подключения к БД используются параметры типа: ${PSQL_SERVER:localhost}, важно, значение идущее после двоеточия, обозначает значение по умолчанию, если параметр не переопределить, то будет использоваться это значение
![](src/main/resources/static/readme/img.png)


Их можно прописать в конфигурации проекта

1 шаг
![](src/main/resources/static/readme/img_1.png)

2 шаг  
![](src/main/resources/static/readme/img_2.png)

3 шаг
![](src/main/resources/static/readme/img_3.png)

в проекте используется checkstyle и мапстракт, для их корректной работы необходимо добавить шаг validate и clean перед билдом

1 шаг
![](src/main/resources/static/readme/img_1.png)

2 шаг добавить add before launch task
![](src/main/resources/static/readme/img_4.png)

3 шаг
![](src/main/resources/static/readme/img_5.png)


4 шаг
![](src/main/resources/static/readme/img_6.png)

5 шаг
![](src/main/resources/static/readme/img_7.png)

6 шаг, проверить порядок!!
![](src/main/resources/static/readme/img_8.png)


## 2. Создание merge request


### 2.1. Создание merge request через карточку
Открываем за асигненую за вами карточку
![](src/main/resources/static/readme/img11.png)


Перед созданием мердж реквеста необходимо задать осмысленное(!) название для ветки,
для этого открой мердж реквест(1), пропишите имя для ветки(2) и убедитесь,
что новая ветка будет создана от **main** ветки(3) (**в данном проекте вместо dev ветки используется main**)
![](src/main/resources/static/readme/img_2_2.png)

В мердж реквесте в разделе **Overview**(1) будут отображаться замечания к коду,
свои изменения можно будет посмотреть в разделе **Changes**(2),
созданная ветка и куда она будет мерджиться можно будет посмотреть в блоке (3),
в случае если мердж реквест нужно изменить, это можно сделать в кнопке **Edit**(4),
после выполнения задания обязательно нажимайте кнопку **Mark as ready**(5),
в гитлабе за асигненые за вами карточки можно просмотреть по кнопке справа в виде
карточек(6), а ваши мердж реквесты в кнопке в виде веток(7)
![](src/main/resources/static/readme/img_3_3.png)


### 2.2. Создание merge request если уже создана ветка
Нажмите на вкладку **Merge request** слева (1), нажмите на кнопку **New merge request** (2)
![](src/main/resources/static/readme/img_1_1.png)

На открывшейся странице выберите в сурса свою ветку (1), проверьте, что в ветке куда вы собрались мерджить свои изменения стоит **main** (2)  ,
нажмите кнопку **Compare branches and continue** (3)
![](src/main/resources/static/readme/img11.png)

На новой странице в селекторе **Assignee** выберите себя (1), в селекторе **Reviewer** выберите проверяющего (2). Проверьте, что стоит чекбокс на удаление после мерджа (3), нажмите кнопку **Create merge request** (4).

### **После создания реквеста приложите ссылку на него в карточку в комментариях**!!!!!!!!!!!!!!

![](src/main/resources/static/readme/img_5_5.png)

## 3. Актуализация ветки и подготовка ее к пуши
Прежде чем запушить свои изменения, необходимо подготовить ветку к отправке.

Чтобы иметь на руках актуальную версию проекта, необходимо обновить мастер-ветку,
это нужно делать каждый раз перед отправкой задачи на проверку
Для этого нажмите на текущую ветку в правом нижнем углу. Выберите опцию **main | update**.
![](src/main/resources/static/readme/img_6_6.png)

Чтобы подтянуть все смерженные коммиты в локальную ветку, в которой вы работаете, нужно:
![](src/main/resources/static/readme/img_7_7.png)

## Инструкция по commit-ам

Предлагаю в принудительном порядке соблюдать стандарт при коммитах, более подробно по стайлгайду
можно ознакомиться по этим статьям и нагуглить дополнительную информацию (важно понимать, что это субъективизм и
на разных проектах могут быть свои правила или их отсутствие)
https://habr.com/ru/company/sberbank/blog/662744/
https://www.conventionalcommits.org/ru/v1.0.0-beta.2/

Далее будет краткое описание правил при написании коммитов, которым мы будем придерживаться в рамках данного проекта


```
<type> [optional область]: <Заголовок краткое описание>
[optional тело] 
[подвал]
```

Есть следующие типы

- fix - исправление багов
- feat - новый функционал
- docs - правки/написание документации
- style - правки код стайла
- test - написание/изменение теста
- refactor - рефактор


В теле описания должны быть ответы на вопросы: «Что?» и «Почему?», если делать это не целесообразно(много кода), можно вкратце описать, как было до и как стало после
В подвале мы указываем номер задачи так: issue #"Номер задачи"

Желательно избегать смешивание коммитов разных типов, но допускается создание дополнительных заголовков в теле

(в данном случае можно описывать коммиты на русском)


## 4. Отправка HTTP-запросов на эндпоинты с секьюрностью в Postman
Прежде чем осуществлять запросы к защищённым эндпоинтам необходимо получить и скопировать `access_token`. 
Для этого можно зарегистрировать нового пользователя с необходимыми ролями или авторизоваться под существующим пользователем.

### 4.1 Регистрация пользователя
_При запуске проекта в бине `TestDataInitializer` инициализируются тестовые данные,
которые содержат пользователей с ролями `USER`, `ADMIN` и `PUBLICIST`, поэтому данный шаг является опциональным. 
Для авторизации можно использовать заранее инициализированного пользователя._

Чтобы зарегистрировать пользователя с помощью запроса в Postman нужно создать новый POST-запрос на адрес
`http://localhost:5557/api/auth/register` (имя сервера и порт могут отличаться в зависимости от вашей конфигурации). 
Во вкладке **Body**, нужно переключить флажок на **raw** и в выпадающем списке справа выбрать **JSON**. 
Затем необходимо прописать тело запроса, которое будет содержать JSON-объект нового пользователя. 
Например, тело запроса для пользователя с ролью `ADMIN`:
```json
{
  "firstName": "Петр",
  "lastName": "Петров",
  "email": "example1@mail.ru",
  "password": "password",
  "birthday": [
    2000,
    3,
    12
  ],
  "roles": [
  {"id": 1, "name": "ADMIN"}
  ]
} 
```
Для пользователя с ролью `USER`:
```json
{
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "example2@mail.ru",
  "password": "password",
  "birthday": [
    2000,
    5,
    7
  ],
  "roles": [
    {"id": 3, "name": "USER"}
  ]
} 
```

Для пользователя с ролью `PUBLICIST`:
```json
{
  "firstName": "Мария",
  "lastName": "Петрова",
  "email": "example3@mail.ru",
  "password": "password",
  "birthday": [
    1989,
    11,
    26
  ],
  "roles": [
    {"id": 2, "name": "PUBLICIST"}
  ]
}
```
![](src/main/resources/static/readme/img_4_1.png)

После успешной регистрации пользователя сервер вернет код ответа 200 OK, а также `access_token`, который можно будет использовать 
для отправки запросов на защищенные эндпоинты (см. п. 4.2), при этом проходить аутентификацию не обязательно, достаточно иметь `access_token`.

### 4.2 Отправка запросов на защищенные эндпоинты
В системе ограничен доступ к эндпоинтам по ролям пользователей:
- `/api/admin/**` - доступен только для пользователей с ролью `ADMIN`;
- `/api/publicist/**` - доступен только для пользователей с ролью `PUBLICIST`;
- `/api/user/**` - доступен только для пользователей с ролью `USER`.

В случае попытки неавторизованного доступа к защищенным эндпоинтам сервер вернет статус ответа **403 Forbidden**. 

Чтобы получить доступ к данным эндпоинтам в Postman нужно скопировать ранее полученный `access_token`, 
затем создать новый запрос на нужный эндпоинт. Например, запрос на эндпонит `/api/admin/users/1` (2)
доступен только пользователю с ролью `ADMIN`. Чтобы получить доступ к защищенному эндпоинту, 
нужно иметь зарегистрированного пользователя с нужной ролью и его `access_token`. При создании запроса в Postman
во вкладке **Authorization** в выпадающем списке **Type** нужно выбрать **Bearer token** (3) и справа в поле (4) вставить
имеющийся `access_token`. После этого можно отправить запрос на защищенный эндпоинт и получить результат (5).

![](src/main/resources/static/readme/img_4_2.png)

### 4.3 Аутентификация и авторизация существующего пользователя
После регистрации пользователя можно пройти авторизацию.
Для авторизации в системе в Postman необходимо создать POST-запрос на адрес: `http://localhost:5557/api/auth/authenticate`.
В тело запроса необходимо прописать JSON-объект с email и паролем пользователя. Например, для ранее созданного пользователя 
с ролью `ADMIN`:
```json
{
    "email": "example1@mail.ru",
    "password": "password"
}
```

После успешной авторизации сервер вернет код ответа 200 OK, а также `access_token` и `refresh_token`. 
Которые можно будет использовать для отправки запросов на защищенные эндпоинты.
![](src/main/resources/static/readme/img_4_3.png)


## Описание сущностей
(ссылка на диаграмму - https://dbdiagram.io/d/61f1b1147cf3fc0e7c6dce0e)


### users - `таблица обозначающая аккаунт пользователя в система`
- id - уникальный идентификатор
- email - почта
- first_name - имя
- last_name - фамилия
- password - пароль
- birthday - дата рождения
- enable - доступность пользователя к системе

### users_role - `связующая таблица` для связи ManyToMany

### roles - `определяет права пользователя в системе`
- id - уникальный идентификатор
- name - наименование роли, имеет тип enum



### score - `таблица отвечающая за оценку пользователей на фильм`
- id - уникальный идентификатор
- movie_id - уникальный идентификатор фильма
- user_id - уникальный идентификатор пользователя
- score - оценка

### movies - `таблица отвечающая за фильмы/сериалы`
- id - уникальный идентификатор
- name - наименование
- original_name - оригинальное наименование фильма
- countries - страны производства
- date_release - дата выхода
- rars - возрастная классификация информационной продукции в России
- mpaa - система рейтингов Американской киноассоциации
- time - продолжительность фильма
- desciption - описание фильма
- type - тип сериал/фильм, принимает следующее значение MOVIES, SERIALS

### genres - `таблица отвечающая за жанры фильмов`
- id - уникальный идентификатор
- name - имя жанра


### persons - `знаменитости разной деятельности в кино`
- id - уникальный идентификатор
- first_name - имя
- last_name - фамилия
- height - рост
- date_birth - дата рождения
- place_of_birth место рождения

### cast - `каст фильма`
- movie_id - уникальный идентификатор фильма
- profession_id - уникальный идентификатор професии
- person_id - уникальный идентификатор персоны(реального человека)
- character_id - уникальный идентификатор персонажа фильмы


### characters - `песонажи фильма`
- id - уникальный идентификатор
- person_id - уникальный идентификатор персоны
- name - имя
- age - возраст
- description - описание
- movie_id - уникальный идентификатор фильма
- type_character - тип персонажа в фильме/сериале, может принимать следующие значения MAIN_CHARACTER, MINOR_CHARACTER, NO_CHARACTER_MOVIE


### dubbing_actors - `актеры дубляжа`
- id - уникальный идентификатор
- character_id - уникальный идентификатор озвучиваемого персонажа
- person_id - уникальный идентификатор персоны
- language - язык озвучки


### professions - `деятельность в кино`
- id - уникальный идентификатор
- name - наименование


### person_marriage - `личный статус персоны`
- id - уникальный идентификатор
- person_id - уникальный идентификатор одной персоны
- human_id - уникальный идентификатор другой персоны
- marriageStatus - сам статус

### excertion - `факты/цитаты персон или персонажей фильма`
- id - уникальный идентификатор
- description - описание
- person_id - уникальный идентификатор персоны
- movie_id - уникальный идентификатор фильма

### folders_movies - `пользовательские папки для отслеживание фильмов`
- id - уникальный идентификатор
- type - тип фолдера, могут принимать следующие значения WAITING_MOVIES("Буду смотреть" ), FAVORITE_MOVIES("Любимые фильмы" ), VIEWED_MOVIES("Просмотренные" ), CUSTOM("Новый список" )
- user_id - уникальный идентификатор пользователя
- privacy - доступность папки для других пользователей, может принимать следующие параметры PRIVATE, PUBLIC
- name - имя для собственных папок
- description - описание

### folders_persons - `пользовательские папки для отслеживание персон`
- id - уникальный идентификатор
- type - тип фолдера, может принимать следующие значения FAVOURITES("Избранное"), CUSTOM("Новая папка")
- user_id - идентификатор пользователя
- privacy - доступность папки для других пользователей, может принимать следующие параметры PRIVATE, PUBLIC
- name - имя для собственных папок
- description - описание

### media - `определяет медия новости`
- id - уникальный идентификатор
- category_id - id категории, к которой относится media
- date - дата публикации
- title - заголовок
- html_body - содержание статьи
- user_id - идентификатор пользователя


### categories - `категория/тип media (к примеру новость, подкаст, тест и т.д.)`
- id - уникальный идентификатор
- name - наименование категории

### questions - `вопросы в media, может использовать как шуточный тест или опросник (еще может расширяться)`
- id - уникальный идентификатор
- name - наименование фильма
- originalName - оригинальное название фильма
- media_id - идентификатор медии

### answers - `ответы на вопрос`
- id - уникальный идентификатор
- answer - ответ
- is_right - указатель на правильный ответ, в нескольких ансверах на один вопрос может быть true
- question_id - идентификатор вопроса

### results - `результат по количеству правильных ответов`
- id - уникальный идентификатор
- count_right_answer - количество правильных ответ
- result - зависит от количества правильных ответов
- question_id - идентификатор вопроса

### reviews - `отзыв к  фильму`
- id - уникальный идентификатор
- type_reviews
- title
- description
- date
- user_id
- movie_id
- is_moderate

### rating_review - `рейтинг комментария`
- id - уникальный идентификатор
- rating - сама оценка (enum)
- review_id - уникальный идентификатор отзыва
- user_id - уникальный идентификатор пользователя

### collections - `подборки фильмов`
- id - уникальный идентификатор
- name - наименование подборки
- enable - отвечает за отображение подборки
- description - описание
- collection_category_id - уникальный идентификатор категорий коллекций

### user_collections - `пользовательские подборки фильмов`
- id - уникальный идентификатор
- user_id - уникальный идентификатор пользователя
- collection_id - уникальный идентификатор коллекций

### collection_category - `категории коллекций`
- id - уникальный идентификатор
- name - наименование


### rating_collection - `рейтинг коллекций от пользователей (де факто оценка)`
- id - уникальный идентификатор
- rating - сама оценка (enum)
- collection_id - уникальный идентификатор коллекций
- user_id - уникальный идентификатор пользователя

### awards_ceremony_result - `результаты церемонии награждения`
- id - уникальный идентификатор
- person_id - уникальный идентификатор пользователя
- movie_id - уникальный идентификатор фильма
- nomination_id - уникальный идентификатор номинации
- awards_ceremony_id - уникальный идентификатор церемонии награждения
- nomination_status - статус номинации, может принимать следующие параметры: NOMINATED, WINNER


### awards_ceremony - `церемония награждения`
- id - уникальный идентификатор
- date_event - дата проведения
- place_event - место проведение
- award_id - уникальный идентификатор награды


### awards - `награда`
- id - уникальный идентификатор
- name - название (к примеру, золотой глобус, оскар, сезар и т.д.)
- place_event - место проведение
- award_id - уникальный идентификатор награды


### nomination - `номинация`
- id - уникальный идентификатор
- name - название номинации


### comments - `комментарии к медиа`
- id - уникальный идентификатор
- message - текст комментария
- date - дата комментария
- is_moderate - проверен ли комментарий модератором
- level - уровень вложенности комментария (1 самый верхний)
- parent_id - уникальный идентификатор родительского комментария (может быть null)
- media_id - уникальный идентификатор медиа


### rating_comment - `рейтинг комментария`
- id - уникальный идентификатор
- rating - сама оценка (enum)
- comment_id - уникальный идентификатор комментария
- user_id - уникальный идентификатор пользователя
