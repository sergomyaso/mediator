# Транзакционный медиатор от команды SAGA #

Береги свою тразакцию от его ROLLBACK

## ENV переменные в appliacation.properties
Товарищ, просунл в пропертя новую перменную, просунь её и в README!

| Переменная     | Описание                         | По умолчанию |
|:---------------|:-----------------------------------|:-----------|
| `spring.datasource.url` | Сервер базы postgres   | `` |
| `spring.datasource.username` | Имя пользователя БД    | `'superadmin'` |
| `spring.datasource.password` | Пароль БД    | `'123123'` |
| `logging.level.nsu.sberlab.mediator` | Уровень логированияя    | `'DEBUG'` |

### Конфигурации для баз сервисов ###
Захардкожены в nsu.sberalb.database.config/database.DatabasesConfig. @TODO перетащить в динамический конфиг файл
### Как создать сразу все базы для разработки? ###
Если ты человек из винды, используй git bash :)
```bash
cd tools

./create_empty_databases.sh
```

### Куда за донатами? ###

* Сергей Алибабаевич +7(913)209-38-55
