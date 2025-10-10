# 📘 Microservice Enseignant (`teacher-microservice`)

Ce microservice fait partie d'une architecture à base de microservices Spring Cloud. Il est dédié à la gestion des enseignants et des départements, en exposant des endpoints RESTful.
Le but du project et d'apprendre le fonctionnement de Springcloud

---

## 🔧 Fonctionnalités

* API REST pour la gestion des enseignants et départements
* Base de données en mémoire (H2) pour le développement et les tests
* Endpoints de monitoring avec Spring Boot Actuator
* Découverte de services et configuration centralisée désactivées (peuvent être activées ultérieurement)
* Développé en Java 21 avec Spring Boot 3.5.6

---

## 🔧 Services

* Departments : Port 8080
* teachers : Ports 8081

---

## 📂 Structure de configuration

Chaque microservice utilise un fichier `application.yaml` similaire, qui contient :

```yaml
server:
  port: 80xx

spring:
  application:
    name: xxxxx-microservice

  datasource:
    url: 'jdbc:h2:mem:xxxxdb'

  h2:
    console:
      enabled: true

  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update

  cloud:
    config:
      enabled: false
    discovery:
      enabled: false

management:
  endpoints:
    web:
      exposure:
        include: '*'
```

---

## 🌐 URLs utiles par service

### Teachers :

| Fonctionnalité     | URL                                                                    |
| ------------------ | ---------------------------------------------------------------------- |
| Console H2         | [http://localhost:8081/h2-console/](http://localhost:8081/h2-console/) |
| Endpoints Actuator | [http://localhost:8081/actuator](http://localhost:8081/actuator)       |

### Departments :

| Fonctionnalité     | URL                                                                    |
| ------------------ |------------------------------------------------------------------------|
| Console H2         | [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/) |
| Endpoints Actuator | [http://localhost:8080/actuator](http://localhost:8080/actuator)       |

### Api Gateway route register

http://localhost:8888/actuator/gateway/routes

**Identifiants H2 :**

* **Nom d'utilisateur :** `sa`
* **Mot de passe :** *(vide)*

**URLs JDBC :**

* Base enseignants : `jdbc:h2:mem:teacherdb`
* Base départements : `jdbc:h2:mem:depdb`

---

## 📦 Dépendances principales

Le projet utilise les dépendances Maven suivantes :

### Spring Boot Starters

* `spring-boot-starter-web` – pour la création d’API REST
* `spring-boot-starter-data-jpa` – pour l'accès aux données via JPA
* `spring-boot-starter-actuator` – pour les endpoints de monitoring
* `spring-boot-starter-test` – pour les tests unitaires

### Spring Cloud

* `spring-cloud-starter-config` – pour la configuration centralisée *(désactivé)*
* `spring-cloud-starter-netflix-eureka-client` – pour la découverte de services *(désactivé)*

### Autres dépendances

* `h2` – base de données en mémoire
* `lombok` – pour réduire le code boilerplate (getters, setters, etc.)
* `spring-boot-devtools` – pour le rechargement automatique en développement

---

## 🚀 Lancement de l’application

1. Cloner le dépôt.
2. Ouvrir le projet dans votre IDE favori.
3. Lancer l’application avec la commande suivante :

```bash
mvn spring-boot:run
```

4. Accéder à la console H2 ou aux endpoints Actuator via les URLs mentionnées ci-dessus.

---

## 🛠️ Compilation et tests

Pour compiler le projet :

```bash
mvn clean install
```

Pour exécuter les tests :

```bash
mvn test
```

---

## 📎 Remarques

* Ce microservice est autonome et ne dépend pas de la découverte de services ou de la configuration centralisée.
* Idéal pour des tests en local et la mise en place de microservices simples.
* La base H2 est uniquement utilisée pour le développement et doit être remplacée par une base persistante en production.
