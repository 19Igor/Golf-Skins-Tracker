# Что нужно, чтобы запустить проект
- Должна быть установлена Java 18
- Установлен maven (3.9.6)
# Как запустить проект
1. Перейдите в корневую папку.
2. Запустите следующие команды
```
mvn clean
mvn package
mvn spring-boot:run
```
Теперь вы можете отправить запросы из postmana
Post запрос: http://localhost:8080/controller/addPlayer
```
{
    "name"    : "Bill",
    "track"   : "Green",
    "sex"     : "man",
    "scores"  : [5, 2, 4, 4, 5, 5, 4, 6, 5, 4, 3, 5, 4, 5, 4, 3, 4, 5]
}
```
Get запрос: http://localhost:8080/controller/getPlayerByName?playerName=Bill
