# quotes-ibash.org.ru
Цитатник из рунета (http://www.ibash.org.ru/)
Парсинг цитат (www.ibash.org.ru/), кэширование в базу данных (запись/получение данных в/из PostgreSQL в контейнере Docker).
Реализация цитатника: 1) через telegram-бот (https://t.me/quotestelegrambot)
                      2) REST-api (исходный сайт не поддерживал api, через данный сервис по REST-запросу находим нужную статью по id в базе или парсинг/кэширование).
                      Для реализации использовался Spring Boot.
