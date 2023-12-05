#!/bin/bash

echo -e "Top 10 overall\n---"
curl http://localhost:8080/scores/top10

echo -e "\n\nTop 2 from Antonio\n---"
curl "http://localhost:8080/scores/top?user=antonio&n=2"

echo -e "\n\nTop 5 overall\n---"
curl "http://localhost:8080/scores/top?n=5"
