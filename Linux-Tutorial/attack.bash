#!/bin/bash

# URL to make requests to
#URL="http://newsly-env.ap-south-1.elasticbeanstalk.com/api/v1/posts?keyword=s"

#URL="https://github.com/Samiran2004"

#URL="https://medicon-nw25.onrender.com/api/v1/health"

URL="https://chatgpt.com/c/68366880-2aec-8010-8613-b61939d1234d"

# Total number of requests to make
TOTAL_REQUESTS=3000

# Initialize counter
count=0

# Optional: Start time for calculating elapsed time
start_time=$(date +%s)

# Function to show progress
show_progress() {
    local percent=$((count * 100 / TOTAL_REQUESTS))
    echo -ne "Progress: $count/$TOTAL_REQUESTS ($percent%)\r"
}

echo "Starting $TOTAL_REQUESTS requests to $URL"
echo "Press Ctrl+C to stop"

# Make the requests
for ((i=1; i<=TOTAL_REQUESTS; i++)); do
    # Make request in background and discard output
    curl -s "$URL" > /dev/null 2>&1 &
    
    # Increment counter
    ((count++))
    
    # Show progress every 100 requests
    if [ $((count % 100)) -eq 0 ]; then
        show_progress
    fi
    
    # Limit concurrent requests to avoid overwhelming the system
    # Wait if there are too many background processes
    if [ $((i % 50)) -eq 0 ]; then
        wait
    fi
done

# Wait for all background processes to complete
wait

# Calculate elapsed time
end_time=$(date +%s)
elapsed=$((end_time - start_time))

# Show final results
echo -e "\nCompleted $TOTAL_REQUESTS requests in $elapsed seconds"
echo "Average: $(echo "scale=2; $TOTAL_REQUESTS / $elapsed" | bc) requests/second"
