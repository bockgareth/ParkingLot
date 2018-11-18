#!/usr/bin/bash

# Stop any instances our theses containers
echo "Attempting to stop any old instances..."
docker container stop parking-lot database
echo "done"

# Flush out old containers
echo "Flushing out old container instances..."
docker container prune
echo "done"

# Destroy old network
echo "Destroying network 'parking-lot-network'"
docker network rm parking-lot-network
echo "Successfully stopped"