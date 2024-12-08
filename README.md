# Mail İle Kullanıcı Kayıt 

Bu proje, Spring Boot ve Spring Security ile geliştirilmiş. Uygulama, kullanıcı uygulamaya kayıt olurken mail onay vermeden uygulamaya girmesi izin verilmiyor.

## Özellikler

- RESTful API ile CRUD işlemleri yapıldı.
- Spring Security kullanarak kullanıcının kayıt olması ve token alması sağlanıyor.
- Mail onay vermeden sisteme giriş yapılmıyor.

## Teknolojiler

- Java 17
- Spring Boot 3.0
- Restful API
- Maven
- Postman


## Endpoints

| Method       | URL             | Açıklama               |
|--------------|-----------------|------------------------|
| `POST`       | `/user/register` | Yeni kullanıcı kaydı   |
| `POST`       | `/user/login`    | Kullanıcı kimlik doğrulama |
| `GET`        | `/verify**`      | Mail onay için kullanılır      |
| `GET`        | `/hello`      | Hello World     |

## Postman
- Kullanıcı Kayıt Olma
```sh
{
    "username" : "kullanıcı",
    "email" : "kullanıcı@gmail.com",
    "password" : "kullanıcı",
    "role" : "USER"
}
```

- Kullanıcı Giriş Yapma
```sh
{   
    "username": "username_admin",
    "password": "password_admin", 
}
```
