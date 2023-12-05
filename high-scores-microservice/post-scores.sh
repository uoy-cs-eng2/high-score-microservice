#!/bin/sh

post_score() {
  USER=$1
  SCORE=$2
  curl -X POST http://localhost:8080/scores \
    -H 'Content-Type: application/json' \
    -d "{\"user\": \"${USER}\", \"score\": ${SCORE}}"
}

post_score antonio 92
post_score alice 101
post_score bob 45
post_score charlie 83
post_score antonio 97
post_score alice 70
post_score bob 66
post_score darry 123
post_score antonio 96
post_score elijah 20
