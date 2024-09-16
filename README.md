# Задание 1

## Требования:

### Создайте аннотации @TrackTime и @TrackAsyncTime, которые можно применять к методам для отслеживания времени их выполнения.

    - Done
        - Файл TrackTime.java
        - Файл TrackAsyncTime.java

    - Сами методы, которые мы тестируем, сделал REST, чтобы удобнее тестировать
        - MainRestController.java

### Реализуйте аспекты, используя Spring AOP, для асинхронного и синхронного отслеживания времени выполнения методов, помеченных соответствующими аннотациями.

    - Done
        - Файл TrackTimeAspect.java

### Создайте сервис, который будет асинхронно сохранять данные о времени выполнения методов в базе данных.

    - Done
        - Файл TimeTrackerStatsOperator.java
        - Метод sendStats сделан асинхронным, чтобы сохранять данные в базу
        - Прочие файлы для JPA

### Реализуйте REST API для получения статистики по времени выполнения методов (например, среднее время выполнения, общее время выполнения) для различных методов и их групп.

    - Done
        - Файл TimeTrackerRestController.java

### Настройте приложение с помощью конфигурации Spring для включения использования AOP и асинхронной обработки данных.

    - Done (если я правильно понял задание)
        - Файл Homework1Application.java
        - @EnableAspectJAutoProxy
        - @EnableAsync

## Примеры использования:

### Дёргаем методы, чтобы спровоцировать "фэйковый workload" и замерить время, которое он даст
- http://localhost:8080/resource1
- http://localhost:8080/resource2
- http://localhost:8080/asyncResource1
- http://localhost:8080/asyncResource2

### Можем получить total конкретного метода
- http://localhost:8080/tt/total/?methodName=com.epromee.ost1.homework1.HelperService%23doHardcoreStuff1

### Можем получить его average
- http://localhost:8080/tt/average/?methodName=com.epromee.ost1.homework1.HelperService%23doHardcoreStuff1

### Можем получить полную статистику по всем методам в виде JSON-списка
- http://localhost:8080/tt/full/