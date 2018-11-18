#!/usr/bin/bash

# Create a VPN for containers to communicate
docker network rm parking-lot-network
echo "Creating network..."
docker network create parking-lot-network
echo "done"

# Stop any instances our theses containers
echo "Attempting to stop any old instances..."
docker container stop parking-lot database
echo "done"

# Flush out old containers
echo "Flushing out old container instances..."
docker container prune
echo "done"

# Run a container with a MySQL instance and attach it to our VPN
echo "Starting database instance..."
docker container run -d --network parking-lot-network --name database -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=parking-lot mysql:8.0.13
echo "done"

# Run a container with our web application instance in it and attach it to our VPN
echo "Starting web application instance..."
docker container run -d --network parking-lot-network --name parking-lot -p 8080:8080 garethbock/parking-lot
echo "done"
echo "Navigate to localhost:8080/tickets or read the documentation on the available routes"
echo "To shutdown the containers, simply run shutdown.sh"
