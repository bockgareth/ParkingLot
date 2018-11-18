# Future Gadget Laboratories presents:
## The Parking Lot 

Future Gadget Laboratories are designing a new parking lot system for all parking lot systems within Japan. This will allow the company to track the revenue generated and also give a little bit of insight into future opportunities within the parking industry.

### Running the Application through:
# Docker 
**(Recommended)**

Pull the parking lot image from DockerHub.
```
docker image pull garethbock/parking-lot
```

Pull a mysql image form DockerHub.
```
docker image pull mysql:8.0.13
```

Now that both images are cached, run
```
startup.sh
```

Navigate to 
```
localhost:8080/tickets
```

To stop the application, simply run
```
shutdown.sh
```

# Docker Compose

**(Unstable)**

To start the application with docker compose, run
```
docker-compose up
```

### 500 Internal error
The developers of docker have stated that docker was not designed to wait for certain containers to be ready before 
deploying new containers. The developers also mention that docker is not suitable for production grade systems that do require this functionality. 
However, features like this come packages with applications such as Kubernetes, where clients have the ability to check 
the health of their containers.

This application uses flyway database migrations in order to migrate the database to the new container. Flyway may
attempt to make a database migration while the database container is not ready, thus it will throw an exception.
In order to fix this issue, simply run `shutdown.sh` followed by `startup.sh`, or if using docker compose, rerun `docker-compose up`.

For more information, visit: `https://docs.docker.com/compose/startup-order/`

## Maven
**(Deprecated)**

Configure `application.properties` to your preferred database schema.

Build the project.

```
mvn clean install
```

Start the embedded Tomcat server.

```
mvn tomcat7:run
```

Navigate to 
```
localhost:8080/tickets
```

## Usage
### Revenue generated for the month.

**Definition**

`GET /reports/<month>`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "month": 11,
        "revenue": 15000
    }
]
```

### Revenue generated for the day.
   
**Definition**

`GET /reports/<month>/<day>`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
   {
       "day": 12,
       "month": 11,
       "revenue": 950
   }
]
```
   
### Revenue generated for the week of a year.

**Definition**

`GET /reports/week/<week>`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "week": 46,
        "revenue": 1260
    }
]
```

### The time distribution of cars entering the complex (in periods of 30 minutes)

**Definition**

`GET /reports/<month>/<day>/entering`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "day": 12,
        "month": 11,
        "time": {
            "09:00": 0,
            "09:30": 0,
            "10:30": 1,
            "10:00": 0,
            "13:00": 2,
            "11:00": 1,
            "12:00": 3,
            "12:30": 1,
            "14:00": 0,
            "15:00": 1,
            "11:30": 1,
            "13:30": 0,
            "14:30": 1
        }
    }
]
```

### The time distribution of cars leaving the complex (in periods of 30 minutes)

**Definition**

`GET /reports/<month>/<day>/leaving`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "day": 12,
        "month": 11,
        "time": {
            "09:00": 0,
            "09:30": 1,
            "10:30": 2,
            "10:00": 0,
            "13:00": 1,
            "11:00": 1,
            "12:00": 3,
            "12:30": 1,
            "14:00": 0,
            "15:00": 3,
            "11:30": 4,
            "13:30": 0,
            "14:30": 1
        }
    }
]
```

### The mode of all the fees paid by drivers for the day.

**Definition**

`GET /reports/<month>/<day>/mode`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "month": 11,
        "day": 12,
        "mode": 30
    }
]
```

Will return 0 if there are multiple modes.


### Number of lost tickets for the day.

**Definition**

`GET /reports/<month>/<day>/lost`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "month": 11,
        "day": 12,
        "lost": 5
    }
]
```


#
### Getting a single ticket.

**Definition**

`GET /tickets/<id>`

**Response**

- `404 Not Found` if the ticket does not exist
- `200 OK` on success

```json
[
    {
        "amountDue": 100,
        "enterTime": "10:30:00",
        "exitTime": "16:30:00",
        "ticketDate": "2018-11-14",
        "ticketId": 1,
        "ticketLost": false
    }
]
```
amountDue, exitTime, and ticketLost will be nulled out until the ticket is closed.

### Getting a collection of tickets.

**Definition**

`GET /tickets`

**Response**

- `404 Not Found` if the tickets do not exist
- `200 OK` on success

```json
[
    {
        "amountDue": 100,
        "enterTime": "10:30:00",
        "exitTime": "16:30:00",
        "ticketDate": "2018-11-14",
        "ticketId": 1,
        "ticketLost": false
    },
    {
        "amountDue": 20,
        "enterTime": "10:30:00",
        "exitTime": "11:30:00",
        "ticketDate": "2018-11-14",
        "ticketId": 2,
        "ticketLost": false
    }
]
```

### Creating a ticket.

**Definition**

`POST /tickets`

**Response**

- `404 Not Found` if the ticket does not exist
- `200 OK` on success

```json
[
    {
        "enterTime": "13:00:00",
        "ticketDate": "2018-12-12",
        "ticketId": 3
    }
]
```

### Closing a ticket.

**Definition**

`PUT /tickets/<id>`

**Request**

```json
[
    {
        "exitTime": "14:00:00",
        "ticketLost": false
    }
]
```

**Response**

- `404 Not Found` if the ticket does not exist
- `200 OK` on success

```json
[
    {
         "amountDue": 20,
         "enterTime": "13:00:00",
         "exitTime": "14:00:00",
         "ticketDate": "2018-11-14",
         "ticketId": 3,
         "ticketLost": false
    }
]
```
