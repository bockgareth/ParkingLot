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

## Usage

### Revenue generated for the month

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

### Revenue generated for the day

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

### Number of lost tickets for the day

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

### The mode of all the fees paid by drivers for the day

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