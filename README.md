# Future Gadget Laboratories presents:
## The Parking Lot 

Future Gadget Laboratories are designing a new parking lot system for all parking lot systems within Japan. This will allow the company to track the revenue generated and also give a little bit of insight into future opportunities within the parking industry.

### Running the Application

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
localhost:8080
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
        "month": "11",
        "revenue": "15000"
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
        "month": "11",
        "day": "12",
        "revenue": "950"
    }
]
```

### Number of lost tickets for the day.

**Definition**

`GET /reports/<month>/<day>/lost`

**Response**

- `404 Not Found` if the report does not exist
- `200 OK` on success

```json
[
    {
        "month": "11",
        "day": "12",
        "lost": "5"
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
        "month": "11",
        "day": "12",
        "mode": "30"
    }
]
```

Will return 0 if there are multiple modes.

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
